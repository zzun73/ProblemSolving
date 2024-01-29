package baekjoon.silver.Num07113;

import java.io.*;
import java.util.*;

public class Main {
    static int helper(int N, int M) {
        if (N == M) {
            return 1;
        }
        if (N == 1 || M == 1) {
            return N * M;
        }

        if (N > M) {
            return 1 + helper(N - M, M);
        } else {
            return 1 + helper(N, M - N);
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(helper(N, M)));

        br.close();
        bw.flush();
        bw.close();
    }
}