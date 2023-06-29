package baekjoon.silver.Num09655;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[1001];
        dp[1] = true;
        dp[2] = false;
        dp[3] = true;
        for (int i = 4; i <= N; i++) {
            dp[i] = !(dp[i - 1] && dp[i - 3]);
        }
        bw.write(dp[N] ? "SK" : "CY");

        br.close();
        bw.flush();
        bw.close();
    }
}
