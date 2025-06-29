import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int depth = Integer.parseInt(br.readLine());

        String a = "*";

        for (int i = 0; i < depth; i++) {
            System.out.println(a.repeat(i + 1));
        }
    }
}