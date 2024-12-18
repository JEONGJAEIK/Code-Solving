import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = Integer.toString(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        a = a.toUpperCase();
        bw.write(a);
        bw.flush();
        bw.close();
    }
}