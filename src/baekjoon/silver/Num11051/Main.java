package baekjoon.silver.Num11051;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] memo;

    private static int helper(int N, int K) {
        if (memo[N][K] != 0) return memo[N][K];

        if (N == K || K == 0) return 1;

        return memo[N][K] = (helper(N - 1, K - 1) + helper(N - 1, K)) % 10007;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        memo = new int[N + 1][K + 1];

        bw.write(helper(N, K) + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
