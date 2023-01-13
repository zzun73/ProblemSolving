package baekjoon.bronze.Num11050;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] memo;

    public static int helper(int n, int k) {

        if (memo[n][k] > 0) {
            return memo[n][k];
        }

        if (k == 0 || n == k) {
            return memo[n][k] = 1;
        }

        return memo[n][k] = helper(n - 1, k - 1) + helper(n - 1, k);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        memo = new int[N + 1][K + 1];

        System.out.println(helper(N, K));
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        st = new StringTokenizer(br.readLine(), " ");
//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//        int first = 1;
//        int second = 1;
//        for (int i = N; i > N - K; i--) {
//            first *= i;
//        }
//        for (int i = K; i > 0; i--) {
//            second *= i;
//        }
//
//        System.out.println(first / second);
//        br.close();
//    }
//}