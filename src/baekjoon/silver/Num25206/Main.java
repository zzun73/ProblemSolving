package baekjoon.silver.Num25206;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        double sum = 0;
        int subject = 0;
        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            st.nextToken();
            double X = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            if (grade.equals("P")) {
                continue;
            }
            subject += X;
            switch (grade) {
                case "A+":
                    sum += X * 4.5;
                    break;
                case "A0":
                    sum += X * 4;
                    break;
                case "B+":
                    sum += X * 3.5;
                    break;
                case "B0":
                    sum += X * 3;
                    break;
                case "C+":
                    sum += X * 2.5;
                    break;
                case "C0":
                    sum += X * 2;
                    break;
                case "D+":
                    sum += X * 1.5;
                    break;
                case "D0":
                    sum += X * 1;
                    break;
                case "F":
                    sum += X * 0;
                    break;
            }
        }
        bw.write(sum / subject + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
