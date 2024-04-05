package baekjoon.silver.Num28447;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, K, answer;
    static int[][] arr;
    static boolean[] visited;

    static void helper(int depth, int idx) {
        if (depth == K) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (visited[i] && visited[j]) {
                        sum += arr[i][j];
                    }
                }
            }
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                helper(depth + 1, idx + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        visited = new boolean[N];
        answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        helper(0, 0);
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}