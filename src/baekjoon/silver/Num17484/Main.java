package baekjoon.silver.Num17484;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][][] dp = new int[N][M][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], 100_000_000);
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                dp[0][i][j] = arr[0][i];
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j > 0) {
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + arr[i][j];
                }
                if (j < M - 1) {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + arr[i][j];
                }
                dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + arr[i][j];
            }
        }


        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                answer = Math.min(answer, dp[N - 1][i][j]);
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}