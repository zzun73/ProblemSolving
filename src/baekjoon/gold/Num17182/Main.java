package baekjoon.gold.Num17182;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, K, answer;
    static int[][] map;
    static boolean[] visited;

    static void helper(int depth, int pos, int sum) {
        if (depth == N) {
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                helper(depth + 1, i, sum + map[pos][i]);
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

        map = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (i == j) {
                    map[i][j] = 100_000_000;
                }
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        answer = Integer.MAX_VALUE;
        visited[K] = true;
        helper(1, K, 0);

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}