package baekjoon.silver.Num11726;

import java.io.*;

public class Main {
    private static final int MOD = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        bw.write(String.valueOf(dp[N]));

        br.close();
        bw.flush();
        bw.close();
    }
}