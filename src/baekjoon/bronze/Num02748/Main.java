package baekjoon.bronze.Num02748;

import java.io.*;

public class Main {
    private static final int MAX_LEN = 91;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[MAX_LEN];
        dp[0] = 0L;
        dp[1] = 1L;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        bw.write(dp[n] + "");

        br.close();
        bw.flush();
        bw.close();
    }
}

