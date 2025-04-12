package baekjoon.silver.Num15663;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, path;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void helper(int depth) {
        if (depth == M) {
            for (int val : path) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1;

        for (int i = 0; i < N; i++) {
            if (!visited[i] && prev != arr[i]) {
                visited[i] = true;
                path[depth] = arr[i];
                helper(depth + 1);
                visited[i] = false;
                prev = path[depth];
            }
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
        visited = new boolean[N];
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