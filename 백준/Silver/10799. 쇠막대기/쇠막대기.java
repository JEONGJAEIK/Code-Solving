import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        arr = input.toCharArray();

        Deque<Character> stack = new ArrayDeque<>();
        stack.push(arr[0]);

        int answer = 0;
        int stick = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == ')') {
                if (arr[i - 1] == '(') {
                  stack.pop();
                  stick--;
                  answer += stick;
                } else {
                    stack.pop();
                    answer++;
                    stick--;
                }
            } else {
                stack.push(arr[i]);
                stick++;
            }
        }
        System.out.println(answer);
    }
}
