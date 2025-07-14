
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int r = 31;
        int result = 0;
        String str = br.readLine();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            int value = c - 96;
            result += (int) (value * Math.pow(r,i));
        }
        System.out.println(result);
    }
}