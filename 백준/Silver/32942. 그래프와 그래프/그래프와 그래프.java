
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, List<Integer>> map = new HashMap<>();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 10; i++) {
            map.put(i, new ArrayList<>());
            for (int j = 1; j <= 10; j++) {
                if (a * i + b * j == c) {
                    map.get(i).add(j);
                }
            }
        }

        for (int i = 1; i <= 10; i++) {
            List<Integer> edges = map.get(i);
            if (edges.isEmpty()) {
                bw.write("0\n");
            } else {
                for (int num : edges) {
                    bw.write(num + " ");
                }
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }
}