
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int l = 0; // 2^l >= n을 만족하는 최소의 l
        for (int i = 1; i < n; i++) {
            if (Math.pow(2, i) >= n) {
                l = i;
                break;
            }
        }
        arr = new long[(int) (Math.pow(2, l) * 2)]; // 세그먼트트리의 길이는 (2^l) * l

        for (int i = 0; i < n; i++) {
            arr[(int) (Math.pow(2, l) + i)] = Long.parseLong(br.readLine()); // 원본배열은 2 ^ l부터 삽입
        }

        // 세그먼트 트리 채우기
        for (int i = (int) (Math.pow(2, l) + (n - 1)); i > 1; i--) { // 원본배열이 담긴 마지막 부터 계산
            int index = i / 2;
            arr[index] += arr[i];
        }

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) { // b를 c로 교체
                // 질의 인덱스를 원본 인덱스로 변환
                int index = (int) (b + Math.pow(2, l) - 1);
                long different = c - arr[index];
                while (index > 0) {
                    arr[index] += different;
                    index = index / 2;
                }

            } else {  // b부터 c까지 합을 구하여 출력
                // 질의 인덱스를 원본 인덱스로 변환
                int start = (int) (b + Math.pow(2, l) - 1);
                int end = (int) (c + Math.pow(2, l) - 1);
                long result = 0;
                while (start <= end) {
                    if (start % 2 == 1) {
                        result += arr[start];
                        start = (start + 1) / 2;
                    } else {
                        start = start / 2;
                    }

                    if (end % 2 == 0) {
                        result += arr[end];
                        end = (end - 1) / 2;
                    } else {
                        end = end / 2;
                    }

                }
                System.out.println(result);
            }
        }
    }
}
