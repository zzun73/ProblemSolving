package baekjoon.silver.Num10971;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int answer;
    static boolean[] visited;

    static void helper(int depth, int start, int prev, int cost) {
        if (depth == N - 1) {
            if (visited[start] && map[prev][start] != 0) {
                answer = Math.min(answer, cost + map[prev][start]);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && map[prev][i] != 0) {
                visited[i] = true;
                helper(depth + 1, start, i, cost + map[prev][i]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            helper(0, i, i, 0);
        }
        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }

}
