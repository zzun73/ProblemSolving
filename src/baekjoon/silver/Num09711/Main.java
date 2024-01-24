package baekjoon.silver.Num09711;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        BigInteger[] dp = new BigInteger[10001];
        dp[0] = BigInteger.valueOf(0);
        dp[1] = BigInteger.valueOf(1);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }

        for (int t = 1; t <= N; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());

            sb.append("Case #").append(t).append(": ").append(dp[P].mod(BigInteger.valueOf(Q))).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}