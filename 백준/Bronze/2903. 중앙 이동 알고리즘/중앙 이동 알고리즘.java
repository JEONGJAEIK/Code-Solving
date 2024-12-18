import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double a = Double.parseDouble(br.readLine());
        System.out.println((int) Math.pow(Math.pow(2,a) + 1, 2));
    }
}