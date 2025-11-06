package baekjoon.silver.Num12407;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, answer, total;
    static int[] arr;
    static boolean[] visited;

    static void helper(int count, int sum) {
        if (count == N / 2) {
            answer = Math.min(Math.abs(sum - (total - sum)), answer);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                helper(count + 1, sum + arr[i]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            arr = new int[N];
            visited = new boolean[N];
            answer = Integer.MAX_VALUE;
            total = 0;
            for (int i = 0; i < N; i++) {
                total += arr[i] = Integer.parseInt(st.nextToken());
            }
            helper(0, 0);

            sb.append("Case #").append(t).append(": ").append(answer).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}