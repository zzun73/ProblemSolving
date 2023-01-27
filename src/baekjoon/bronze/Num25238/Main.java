package baekjoon.bronze.Num25238;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        double a = Long.parseLong(st.nextToken());
        double b = Long.parseLong(st.nextToken());

        double calc = a - a * (b / 100);
        if (calc >= 100) {
            bw.write("0");
        } else {
            bw.write("1");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
