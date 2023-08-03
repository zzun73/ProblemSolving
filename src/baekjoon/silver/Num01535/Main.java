package baekjoon.silver.Num01535;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] w = new int[N + 1];
        int[] v = new int[N + 1];
        int[] dp = new int[100];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            w[i] = Integer.parseInt(st.nextToken());

        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = dp.length - 1; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        bw.write(dp[dp.length - 1] + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
