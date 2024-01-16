package baekjoon.silver.Num02502;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int A, B, D, K;

    static String helper() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= K / 2; i++) {
            for (int j = i; j <= K; j++) {
                if ((i * A) + (j * B) == K) {
                    sb.append(i).append("\n").append(j);
                    return sb.toString();
                }
            }
        }
        return "";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] dp = new int[31];
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= D; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        A = dp[D - 1];
        B = dp[D];

        bw.write(helper());

        br.close();
        bw.flush();
        bw.close();
    }
}