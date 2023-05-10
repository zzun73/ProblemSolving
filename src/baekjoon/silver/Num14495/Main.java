package baekjoon.silver.Num14495;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[117];
        dp[1] = dp[2] = dp[3] = 1;

        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 3];
        }
        bw.write(dp[N] + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
