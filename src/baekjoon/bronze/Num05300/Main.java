package baekjoon.bronze.Num05300;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            sb.append(i);
            sb.append(i % 6 == 0 ? " Go! " : " ");
        }
        sb.append(N % 6 != 0 ? "Go!" : "");

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}