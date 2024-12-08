import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = br.readLine();
        int[] arr = new int[26];

        for (int i = 0; i < a.length(); i++) {
            char b = a.charAt(i);
            if (arr[b - 'a'] != 0) {
                arr[b - 'a'] += 1;
            } else {
                arr[b - 'a'] = 1;
            }
        }

        for (int i : arr) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }
}