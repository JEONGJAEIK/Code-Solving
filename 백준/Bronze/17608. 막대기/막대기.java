import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sticks = new int[N];

        for (int i = 0; i < N; i++) {
            sticks[i] = Integer.parseInt(br.readLine());
        }

        int visibleCount = 1;  // 맨 마지막 막대기는 무조건 보임
        int maxHeight = sticks[N - 1];

        for (int i = N - 2; i >= 0; i--) {
            if (sticks[i] > maxHeight) {
                visibleCount++;
                maxHeight = sticks[i];
            }
        }

        System.out.println(visibleCount);
    }
}