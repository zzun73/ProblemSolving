package baekjoon.silver.Num04132;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static long answer;
    static int[] arr;

    static void helper(int depth, long sum) {

        if (depth == M) {
            if (sum >= N) {
                answer = Math.min(answer, sum);
            }
            return;
        }

        helper(depth + 1, sum + arr[depth]);
        helper(depth + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        answer = Long.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        helper(0, 0);
        bw.write(String.valueOf(answer == Integer.MAX_VALUE ? "IMPOSSIBLE" : answer));

        br.close();
        bw.close();
    }

}