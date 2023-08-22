package baekjoon.gold.Num02294;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    private static final int INF = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        int[] dp = new int[k + 1];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j - coin[i]] + 1, dp[j]);
            }
        }
        bw.write(String.valueOf(dp[k] == INF ? -1 : dp[k]));

        br.close();
        bw.flush();
        bw.close();
    }
}