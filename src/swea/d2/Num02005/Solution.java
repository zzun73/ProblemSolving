package swea.d2.Num02005;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] dp = new int[N][N];

            dp[0][0] = 1;
            sb.append("#").append(t).append("\n").append(dp[0][0]).append("\n");
            for (int i = 1; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0) {
                        dp[i][j] = 1;
                        sb.append(dp[i][j]);
                    } else if (i == j) {
                        dp[i][j] = 1;
                        sb.append(dp[i][j]);
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                        sb.append(dp[i][j]);
                    }
                    sb.append(" ");
                }
                sb.append("\n");
            }
        }
        sb.append("\n");
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}