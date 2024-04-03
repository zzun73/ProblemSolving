package baekjoon.silver.Num18429;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, K, answer;
    static int[] kits;
    static boolean[] visited;

    static void helper(int depth, int weight) {
        if (depth == N) {
            answer++;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (weight - K + kits[i] >= 500) {
                    visited[i] = true;
                    helper(depth + 1, weight - K + kits[i]);
                    visited[i] = false;
                }
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
        answer = 0;
        kits = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            kits[i] = Integer.parseInt(st.nextToken());
        }

        helper(0, 500);

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }

}