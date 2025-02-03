package baekjoon.silver.Num17271;

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

        long[] dp = new long[Math.max(N, M) + 1];
        for (int i = 0; i <= M; i++) {
            dp[i] = 1;
        }

        for (int i = M; i <= N; i++) {
            dp[i] = (dp[i - M] + dp[i - 1]) % 1_000_000_007;
        }

        bw.write(String.valueOf(dp[N]));

        br.close();
        bw.close();
    }
}