package baekjoon.silver.Num01932;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                dp[i - 1][j] = Math.max(dp[i][j], dp[i][j + 1]) + dp[i - 1][j];
            }
        }
        bw.write(dp[0][0] + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
