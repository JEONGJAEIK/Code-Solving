
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int count = 0;
        int start = 1;
        int end = 1;
        int sum = 1;


        while (start <= number) {
            if (sum == number) {
                count++;
                sum -= start;
                start++;
            } else if (sum < number) {
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }

        System.out.println(count);
    }
}
