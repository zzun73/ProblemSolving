package baekjoon.silver.Num13301;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[81];
        dp[1] = 4;
        dp[2] = 6;

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        bw.write(String.valueOf(dp[N]));

        br.close();
        bw.flush();
        bw.close();
    }
}