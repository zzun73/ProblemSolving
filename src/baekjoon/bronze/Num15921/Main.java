package baekjoon.bronze.Num15921;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        bw.write(N == 0 ? "divide by zero" : "1.00");

        br.close();
        bw.flush();
        bw.close();
    }
}
