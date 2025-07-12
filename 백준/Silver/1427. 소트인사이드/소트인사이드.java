import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();

        String input = br.readLine();
        for (char c : input.toCharArray()) {
            list.add((int) c - 48);
        }

        list.sort(Comparator.reverseOrder());
        for (Integer integer : list) {
            sb.append(integer + "");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}