package baekjoon.silver.Num18422;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, answer;
    static char[][] map;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static Deque<int[]> deque;

    static void helper(int sx, int sy) {
        deque.add(new int[]{sx, sy});
        map[sx][sy] = '.';

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1 || map[nx][ny] == '.') {
                    continue;
                }
                map[nx][ny] = '.';
                deque.add(new int[]{nx, ny});
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
        deque = new ArrayDeque<>();
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '*') {
                    helper(i, j);
                    answer++;
                }
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}