package baekjoon.gold.Num02294;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];
        int[] dp = new int[k + 1];
        for (int i = 0; i < coin.length; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        Arrays.fill(dp, 10001);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j >= coin[i]) {
                    dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
                }
            }
        }
        bw.write(dp[k] == 10001 ? "-1" : dp[k] + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
