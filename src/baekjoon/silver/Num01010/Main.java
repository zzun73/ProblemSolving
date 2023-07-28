package baekjoon.silver.Num01010;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] memo;

    private static int helper(int N, int K) {
        if (memo[N][K] != 0) return memo[N][K];

        if (N == K || K == 0) return 1;

        return memo[N][K] = (helper(N - 1, K - 1) + helper(N - 1, K));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            memo = new int[M + 1][N + 1];

            sb.append(helper(M, N)).append("\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();

    }
}
