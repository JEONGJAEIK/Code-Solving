import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[3];
        if (a > b && b > c) {
            arr[0] = c;
            arr[1] = b;
            arr[2] = a;
        } else if (a > c && c > b) {
            arr[0] = b;
            arr[1] = c;
            arr[2] = a;
        } else if (b > a && a > c) {
            arr[0] = c;
            arr[1] = a;
            arr[2] = b;
        } else if (b > c && c > a) {
            arr[0] = a;
            arr[1] = c;
            arr[2] = b;
        } else if (c > a && a > b) {
            arr[0] = b;
            arr[1] = a;
            arr[2] = c;
        } else {
            arr[0] = a;
            arr[1] = b;
            arr[2] = c;
        }

        for (int i : arr) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }
}