package baekjoon.silver.Num15656;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, path;
    static StringBuilder sb = new StringBuilder();

    static void helper(int depth) {
        if (depth == M) {
            for (int val : path) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            path[depth] = arr[i];
            helper(depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        path = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        helper(0);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}