import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int number = Integer.parseInt(br.readLine());
        int vote = 0;

        for (int i = 0; i < number; i++) {
            vote += Integer.parseInt(br.readLine());
            }

        if ((number + 1) / 2 > vote) {
            bw.write("Junhee is not cute!");
        } else {
            bw.write("Junhee is cute!");
        }

        bw.flush();
        br.close();
    }

}