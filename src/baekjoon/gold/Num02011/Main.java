package baekjoon.gold.Num02011;

import java.io.*;

public class Main {
    private static final int MOD = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();
        int size = input.length;
        int[] arr = new int[size + 1];
        long[] dp = new long[size + 1];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = input[i - 1] - '0';
        }

        if (arr[1] != 0) {
            dp[0] = 1;
            dp[1] = (arr[1] != '0') ? 1 : 0;

            for (int i = 2; i < arr.length; i++) {
                if (arr[i] != 0) {
                    dp[i] += dp[i - 1] % MOD;
                }

                int value = arr[i - 1] * 10 + arr[i];
                if (value >= 10 && value <= 26) {
                    dp[i] += dp[i - 2] % MOD;
                }
            }
        }

        bw.write(String.valueOf(dp[size] % MOD));

        br.close();
        bw.close();
    }
}