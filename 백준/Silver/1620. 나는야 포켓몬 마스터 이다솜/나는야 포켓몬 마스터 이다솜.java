import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        int n = Integer.parseInt(st.nextToken()); // 도감에 있는 포켓몬 수
        int m = Integer.parseInt(st.nextToken()); // 문제 수

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            map.put(name, i);
            list.add(name);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String query = br.readLine();
            if (isNumeric(query)) {
                int num = Integer.parseInt(query);
                sb.append(list.get(num - 1)).append("\n");
            } else {
                sb.append(map.get(query) + 1).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d+"); // 양의 정수만 허용
    }
}