package baekjoon.silver.Num17175;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[51];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + 1) % 1_000_000_007;
        }
        bw.write(String.valueOf(dp[N]));

        br.close();
        bw.flush();
        bw.close();
    }
}