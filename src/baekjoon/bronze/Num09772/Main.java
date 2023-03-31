package baekjoon.bronze.Num09772;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            if (x == 0 || y == 0) {
                bw.write("AXIS");
            } else {
                if (x > 0) {
                    bw.write(y > 0 ? "Q1" : "Q4");
                } else {
                    bw.write(y > 0 ? "Q2" : "Q3");
                }
            }
            bw.write("\n");
            if (x == 0 && y == 0) {
                break;
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
