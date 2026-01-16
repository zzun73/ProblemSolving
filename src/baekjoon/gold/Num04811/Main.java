package baekjoon.gold.Num04811;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        long[] dp = new long[31];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            long sum = 0;
            for (int j = 0; j < i; j++) {
                sum += dp[j] * dp[i - 1 - j];
            }
            dp[i] = sum;
        }

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            sb.append(dp[N]).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}