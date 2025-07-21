
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 더하기만 있을 땐 괄호로 할 수 있는 것이 없다.
// 즉 -로 분리하고 더하기는 한 묶음으로 보면 된다.
// 최소 값을 구하기 위해서는 -(A + B)가 최우선 일테니
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String[] splitByMinus = input.split("-");

        int result = 0;

        result += sum(splitByMinus[0]);

        for (int i = 1; i < splitByMinus.length; i++) {
            result -= sum(splitByMinus[i]);
        }

        System.out.println(result);
    }

    private static int sum(String expression) {
        String[] nums = expression.split("\\+");
        int total = 0;
        for (String num : nums) {
            total += Integer.parseInt(num);
        }
        return total;
    }
}