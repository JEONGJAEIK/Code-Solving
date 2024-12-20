import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                arr.add(i);
            }
        }

        Collections.sort(arr);
        try {
            int answer = arr.get(b - 1);
            bw.write(answer + "\n");
            bw.flush();
            bw.close();
        } catch (Exception e) {
            bw.write("0");
            bw.flush();
            bw.close();
        }
    }
}