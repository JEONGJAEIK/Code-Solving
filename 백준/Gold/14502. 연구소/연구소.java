
import java.io.*;
import java.util.*;

// 골드 4 연구소
public class Main {
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int N, M;
    static List<int[]> virus = new ArrayList<>();
    static int[][] map;
    static int maxSafe = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) virus.add(new int[]{i, j});
            }
        }

        // DFS로 벽 3개를 조합
        buildWalls(0, 0);

        System.out.println(maxSafe);
    }

    static void buildWalls(int count, int start) {
        if (count == 3) {
            int[][] tempMap = new int[N][M];
            for (int i = 0; i < N; i++) tempMap[i] = map[i].clone();

            bfs(tempMap);

            int safe = countSafe(tempMap);
            maxSafe = Math.max(maxSafe, safe);
            return;
        }

        for (int i = start; i < N * M; i++) {
            int y = i / M;
            int x = i % M;
            if (map[y][x] == 0) {
                map[y][x] = 1;
                buildWalls(count + 1, i + 1);
                map[y][x] = 0;
            }
        }
    }

    static void bfs(int[][] tempMap) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();

        for (int[] v : virus) queue.add(v);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0], x = cur[1];
            visited[y][x] = true;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (!visited[ny][nx] && tempMap[ny][nx] == 0) {
                        tempMap[ny][nx] = 2;
                        queue.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }

    static int countSafe(int[][] tempMap) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 0) count++;
            }
        }
        return count;
    }
}
