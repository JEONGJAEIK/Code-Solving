import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        int b = 0;
        int i = 1;
        while (b + i < a) {
            b = b + i;
            i = i + 1;
        }


        int c = (i + 1) - (a - b);
        int d = (a - b);

        if (i % 2 == 1) {
            bw.write(c + "/" + d);
        } else {
            bw.write(d + "/" + c);
        }
        bw.flush();
        bw.close();
    }
}