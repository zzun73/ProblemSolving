package baekjoon.silver.Num14494;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[][] dp = new long[N + 1][M + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (i * j == 1) {
                    continue;
                }
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1]) % 1_000_000_007;
            }
        }
        bw.write(String.valueOf(dp[N][M]));

        br.close();
        bw.flush();
        bw.close();
    }
}