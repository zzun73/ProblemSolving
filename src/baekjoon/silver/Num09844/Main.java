package baekjoon.silver.Num09844;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] arr = new int[h][w];
        int[][] dp = new int[h][w];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < w; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.arraycopy(arr[0], 0, dp[0], 0, w);

        for (int i = 1; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (j == 0 && j + 1 < w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j + 1]) + arr[i][j];
                } else if (j == w - 1 && j > 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + arr[i][j];
                } else if (j > 0 && j < w - 1) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i - 1][j + 1])) + arr[i][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + arr[i][j];
                }
            }
        }

        int answer = -1;
        for (int i = 0; i < w; i++) {
            answer = Math.max(answer, dp[h - 1][i]);
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}