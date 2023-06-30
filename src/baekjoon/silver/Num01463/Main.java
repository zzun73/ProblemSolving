package baekjoon.silver.Num01463;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 6 == 0) {
                dp[i] = Math.min(Math.min(dp[i / 3] + 1, dp[i / 2] + 1), dp[i]);
            } else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
            }
        }
        bw.write(dp[N] + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
