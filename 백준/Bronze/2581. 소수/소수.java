import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //에라토스테네스의 체 (소수 구하기)
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int start = 0;
        int end = 0;

        if (a > b) {
            end = a;
            start = b;
        } else {
            start = a;
            end = b;
        }


        check(end, start);


    }

    static void check(int end, int start) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Boolean> list = new ArrayList<>();
        ArrayList<Integer> primes = new ArrayList<>();

        int sum = 0;

        for (int i = 0; i <= end; i++) {
            list.add(true);
        }

        list.set(0, false);
        list.set(1, false);

        for (int i = 2; i <= Math.sqrt(end); i++) {
            if (list.get(i)) {
                for (int j = i * i; j <= end; j += i) {
                    list.set(j, false);
                }
            }
        }

        for (int i = 2; i <= end; i++) {
            if (list.get(i)) {
               primes.add(i);
            }
        }

        Iterator<Integer> iterator = primes.iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            if (i < start) {
                iterator.remove();
            }
        }

        for (int i : primes) {
            sum += i;
        }

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