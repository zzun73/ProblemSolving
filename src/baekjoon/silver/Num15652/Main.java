package baekjoon.silver.Num15652;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    public static void helper(int depth, int start) {
        if (depth == M) {
            for (int value : arr) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            arr[depth] = i + 1;
            helper(depth + 1, i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        helper(0, 0);
        System.out.println(sb);

        br.close();
    }
}
