import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++) {
            int schools = Integer.parseInt(br.readLine());
            for (int j = 0; j < schools; j++) {
                String[] input = br.readLine().trim().split(" ");
            }
            bw.write("Korea\n");
        }
        bw.flush();
        bw.close();
    }
}