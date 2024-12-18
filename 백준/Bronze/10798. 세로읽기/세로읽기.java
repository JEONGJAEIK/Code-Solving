import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ArrayList<Character>> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            ArrayList<Character> subList = new ArrayList<>();
            for (char c : line.toCharArray()) {
                subList.add(c);
            }
            list.add(subList);
        }
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < 15; i++) {
            for (ArrayList<Character> subList : list) {
                if (subList.size() > i) {
                    answer.append(subList.get(i));
                }
            }
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }
}