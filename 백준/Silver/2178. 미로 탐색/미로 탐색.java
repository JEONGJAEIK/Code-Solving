import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int width, height;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] field, visited;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        field = new boolean[height][width];
        visited = new boolean[height][width];
        dist = new int[height][width];

        for (int y = 0; y < height; y++) {
            String line = br.readLine();
            for (int x = 0; x < width; x++) {
                field[y][x] = line.charAt(x) - '0' == 1;
            }
        }

        int result = bfs();
        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < height && nx >= 0 && nx < width) {
                    if (field[ny][nx] && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny, nx});
                        dist[ny][nx] = dist[y][x] + 1;
                    }
                }
            }
        }
        return dist[height - 1][width -1];
    }
}
