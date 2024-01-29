package baekjoon.bronze.Num05956;

import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;

    static void helper(int depth, int N, int M) {
        if (N % 2 == 0 || M % 2 == 0) {
            return;
        }
        answer += Math.pow(4, depth);
        helper(depth + 1, N / 2, M / 2);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        answer = 0;
        helper(0, N, M);
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}