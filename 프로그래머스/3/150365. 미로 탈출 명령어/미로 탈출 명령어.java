class Solution {
    static int n, m, r, c, k;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static char[] dir = {'d', 'l', 'r', 'u'};
    static String answer = "impossible";
    static boolean found = false;

    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n;
        this.m = m;
        this.r = r;
        this.c = c;
        this.k = k;
        dfs(x, y, 0, new StringBuilder());
        return answer;
    }
    
    private void dfs(int x, int y, int distance, StringBuilder path) {
        if (found) {
            return;
        }
        
        int remain = k - distance; // 앞으로 이동가능한 횟수
        int dist = Math.abs(x - r) + Math.abs(y - c); // 최소 필요 이동거리
        
        // 필요 이동거리가 앞으로 이동가능한 경우보다 많을 때, 남은 거리가 홀수일 
        if (dist > remain || (remain - dist) % 2 == 1) {
            return;
        }
        
        if (distance == k) {
            if (x == r && y == c) {
                answer = path.toString();
                found = true;
            }
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (1 <= nx && 1 <= ny && nx <= n && ny <= m) {
                path.append(dir[i]);
                dfs(nx, ny, distance + 1, path);
                path.deleteCharAt(path.length() - 1);
            }
        } 
    }
}