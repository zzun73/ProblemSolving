package baekjoon.silver.Num16439;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer;
    static int[][] map;
    static boolean[] selected;

    static void helper(int depth, int start) {
        if (depth == 3) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                int temp = 0;
                for (int j = 0; j < M; j++) {
                    if (selected[j]) {
                        temp = Math.max(temp, map[i][j]);
                    }
                }
                sum += temp;
            }
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = start; i < M; i++) {
            if (!selected[i]) {
                selected[i] = true;
                helper(depth + 1, i + 1);
                selected[i] = false;
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

        map = new int[N][M];
        selected = new boolean[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        helper(0, 0);
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}