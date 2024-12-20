import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            ArrayList<Integer> arr = new ArrayList<>();
            int a = Integer.parseInt(br.readLine());
            int b = 0;

            if (a == -1) {
                break;
            }

            for (int i = 1; i < a; i++) {
                if (a % i == 0) {
                    arr.add(i);
                }
            }

            for (int j : arr) {
                b += j;
            }

            Collections.sort(arr);

            if (b == a) {
                bw.write(a+ " = ");
                for (int j : arr) {
                    if (j == arr.get(arr.size() - 1))  {
                        bw.write(String.valueOf(j));
                    } else {
                        bw.write(j + " + ");
                    }
                }
            } else {
                bw.write(a + " is NOT perfect. ");
            }
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}