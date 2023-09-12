package baekjoon.silver.Num11048;

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
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] += Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
            }
        }
        bw.write(String.valueOf(dp[N][M]));

        br.close();
        bw.flush();
        bw.close();
    }
}
