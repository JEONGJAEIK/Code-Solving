import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위한 객체

        int a = Integer.parseInt(br.readLine()); // 시작 숫자 입력
        int b = Integer.parseInt(br.readLine()); // 끝 숫자 입력

        check(a, b); // check는 소수를 검출하는 메서드이다
    }


    static void check(int start, int end) throws IOException {
        //출력을 위한 객체
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Boolean> list = new ArrayList<>(); // 소수 판별을 위한 불린리스트
        ArrayList<Integer> primes = new ArrayList<>(); // 불린값을 숫자로 바꾸기 위한 리스트
        int sum = 0;

        // 0부터 끝까지의 모든 리스트 값을 1로 만든다
        // (소수는 1로 지정하고 소수가 아니면 0으로 지정할 생각)
        // 불린 리스트의 인덱스 값이 곧 숫자값을 뜻한다.

        for (int i = 0; i <= end; i++) {
            list.add(true);
        }

        // 0,1은 소수가 아니기에 0으로 지정한다
        list.set(0, false);
        list.set(1, false);

        // 가장 작은 수를 제외한 그의 배수들을 0으로 지정한다 (에라스토테네스의 체)
        for (int i = 2; i <= Math.sqrt(end); i++) {
            if (list.get(i)) {
                for (int j = i * i; j <= end; j += i) {
                    list.set(j, false);
                }
            }
        }
        // 2부터 끝까지 1값을 가지고 있는 모든 인덱스를 (인덱스는 숫자값) 인티저 리스트에 추가한다.
        for (int i = 2; i <= end; i++) {
            if (list.get(i)) {
                primes.add(i);
            }
        }

        // start보다 작은 수를 모두 삭제한다.
        // 리스트를 순회하며 삭제하는 경우 오류가 뜨기때문에 iterator를 이용하여하면 오류가 뜨지않는다
        Iterator<Integer> iterator = primes.iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            if (i < start) {
                iterator.remove();
            }
        }

        // 인티저 리스트에 있는 모든 소수들을 더한다
        for (int i : primes) {
            sum += i;
        }

        // 인티저 리스트에 소수가 없으면 (지정한 숫자들 사이에 소수가 아예없는 경우) -1를 출력한다
        // 소수가 있는경우 소수의 합과 소수들 중 최솟값을 출력한다.
        if (primes.isEmpty()) {
            bw.write(-1 + "\n");
            bw.flush();
            bw.close();
        } else {
            bw.write(sum + "\n");
            bw.write(primes.get(0) + "\n");
            bw.flush();
            bw.close();
        }
    }
}
