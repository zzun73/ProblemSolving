package baekjoon.silver.Num02407;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static BigInteger[][] memo;

    static BigInteger helper(int n, int m) {

        if (memo[n][m] != null) {
            return memo[n][m];
        }

        if (n == m || m == 0) {
            return memo[n][m] = BigInteger.ONE;
        }

        return memo[n][m] = helper(n - 1, m - 1).add(helper(n - 1, m));

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        memo = new BigInteger[N + 1][N + 1];

        bw.write(helper(N, M).toString());

        br.close();
        bw.close();
    }
}