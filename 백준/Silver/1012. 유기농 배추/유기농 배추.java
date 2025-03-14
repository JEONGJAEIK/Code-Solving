import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] field;
    static boolean[][] visited;
    static int M, N, K;
    static int count;

    // 상, 하, 좌, 우 방향 이동
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로 크기 (열)
            N = Integer.parseInt(st.nextToken()); // 세로 크기 (행)
            K = Integer.parseInt(st.nextToken()); // 배추 개수

            field = new int[N][M];       // 2D 배열 (N: 행, M: 열)
            visited = new boolean[N][M]; // 방문 체크 배열 초기화
            count = 0;

            // 배추 위치 입력
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // 열 좌표
                int y = Integer.parseInt(st.nextToken()); // 행 좌표

                field[y][x] = 1; // 2D 배열은 field[y][x] 형태로 접근
            }

            // DFS 수행
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (field[y][x] == 1 && !visited[y][x]) {
                        dfs(y, x); // 올바른 좌표 순서
                        count++;
                    }
                }
            }

            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 배열 범위 확인
            if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                if (field[ny][nx] == 1 && !visited[ny][nx]) {
                    dfs(ny, nx); // 좌표 순서 맞춰서 호출
                }
            }
        }
    }
}