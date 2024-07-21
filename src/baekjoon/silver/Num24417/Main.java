package baekjoon.silver.Num24417;

import java.io.*;

public class Main {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        long x = 1, y = 1;
        for (int i = 0; i < N - 2; i++) {
            long temp = y;
            y = (x + y) % MOD;
            x = temp;
        }
        sb.append(y).append(" ").append(N - 2);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}