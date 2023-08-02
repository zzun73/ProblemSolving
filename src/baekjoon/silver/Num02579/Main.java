package baekjoon.silver.Num02579;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N + 1];
        long[] dp = new long[N + 1];
        for (int i = 1; i < stairs.length; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if (N >= 1) dp[1] = stairs[1];
        if (N >= 2) dp[2] = stairs[1] + stairs[2];
        for (int i = 3; i < stairs.length; i++) {
            dp[i] = Math.max(dp[i - 3] + stairs[i - 1] + stairs[i], dp[i - 2] + stairs[i]);
        }
        bw.write(dp[N] + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
