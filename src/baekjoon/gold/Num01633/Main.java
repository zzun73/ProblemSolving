package baekjoon.gold.Num01633;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] black;
    static int[] white;
    static int[][][] dp;

    static int helper(int index, int whiteCount, int blackCount) {
        if (index == N) {
            return 0;
        }

        if (dp[index][whiteCount][blackCount] != -1) {
            return dp[index][whiteCount][blackCount];
        }

        int result = helper(index + 1, whiteCount, blackCount);

        if (whiteCount < 15) {
            result = Math.max(result, white[index] + helper(index + 1, whiteCount + 1, blackCount));
        }
        if (blackCount < 15) {
            result = Math.max(result, black[index] + helper(index + 1, whiteCount, blackCount + 1));
        }

        return dp[index][whiteCount][blackCount] = result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = 0;
        black = new int[1001];
        white = new int[1001];
        String str;
        while ((str = br.readLine()) != null) {
            st = new StringTokenizer(str, " ");
            white[N] = Integer.parseInt(st.nextToken());
            black[N] = Integer.parseInt(st.nextToken());
            N++;
        }
        dp = new int[N][16][16];
        for (int[][] arr : dp) {
            for (int[] row : arr) {
                Arrays.fill(row, -1);
            }
        }
        bw.write(String.valueOf(helper(0, 0, 0)));

        br.close();
        bw.close();
    }
}