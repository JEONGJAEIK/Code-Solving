import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.NaN;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double totalcredit = 0;
        double totalgrade = 0;
        double answer = 0;

        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            totalgrade += calculateGrade(credit, grade);
            totalcredit += calculateCredit(credit, grade);
        }
        answer += totalgrade / totalcredit;
        if (Double.isNaN(answer)) {
            answer = 0;
        }
        answer = Math.round(answer * 1000000) / 1000000.0;
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    static double calculateGrade(double credit, String grade) {
        double gradeInt = 0;
        if (grade.equals("A+")) {
            gradeInt = 4.5;
        } else if (grade.equals("A0")) {
            gradeInt = 4.0;
        } else if (grade.equals("B+")) {
            gradeInt = 3.5;
        } else if (grade.equals("B0")) {
            gradeInt = 3.0;
        } else if (grade.equals("C+")) {
            gradeInt = 2.5;
        } else if (grade.equals("C0")) {
            gradeInt = 2.0;
        } else if (grade.equals("D+")) {
            gradeInt = 1.5;
        } else if (grade.equals("D0")) {
            gradeInt = 1.0;
        } else if (grade.equals("F")) {
            gradeInt = 0;
        } else {
            return 0;
        }
        return credit * gradeInt;
    }

    static double calculateCredit(double credit, String grade) {
        if (grade.equals("P")) {
            return 0;
        }
        return credit;
    }
}