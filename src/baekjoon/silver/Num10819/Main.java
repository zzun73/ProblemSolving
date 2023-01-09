package baekjoon.silver.Num10819;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, answer;
    static int[] arr,path;
    static boolean[] visited;

    public static void helper(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(path[i] - path[i + 1]);
            }
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path[depth] = arr[i];
                helper(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        path = new int[N];
        answer = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        helper(0);
        System.out.println(answer);

        br.close();
    }
}
