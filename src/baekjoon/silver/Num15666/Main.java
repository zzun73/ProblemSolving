package baekjoon.silver.Num15666;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, path;
    static StringBuilder sb = new StringBuilder();
    static int N, M, prev;

    public static void helper(int depth) {
        if (depth == M) {
            for (int value : arr) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (prev >= path[i]) {
                continue;
            }
            arr[depth] = path[i];
            helper(depth + 1);
            prev = path[i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        path = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            path[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(path);
        helper(0);
        System.out.println(sb);

        br.close();
    }
}