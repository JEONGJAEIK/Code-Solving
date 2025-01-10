import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {
            int classes = Integer.parseInt(br.readLine());
            int grade = 0;
            double gpa = 0;
            for (int j = 0; j < classes; j++) {
                String line = br.readLine();
                String[] input = line.split(" ");
                int now_grade = Integer.parseInt(input[0]);
                double now_gpa = Double.parseDouble(input[1]);
                grade += now_grade;
                gpa += now_grade * now_gpa;
            }
            bw.write(grade + "\n");
            bw.write(Math.round((gpa / grade) * 10) / 10.0 + "\n");
            bw.flush();
        }
        bw.close();
    }
}
