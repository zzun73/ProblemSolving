package baekjoon.silver.Num10974;

import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void helper(int depth) {
        if (depth == N) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                helper(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];

        helper(0);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
