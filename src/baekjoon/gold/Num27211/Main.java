package baekjoon.gold.Num27211;

import java.io.*;
import java.util.*;

public class Main {
    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, answer;
    static int[][] map;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static Deque<Pos> deque;

    static void helper(int x, int y) {
        deque = new ArrayDeque<>();
        map[x][y] = 1;
        deque.add(new Pos(x, y));

        while (!deque.isEmpty()) {
            Pos cur = deque.poll();

            for (int i = 0; i < 4; i++) {
                int nx = (N + cur.x + dx[i]) % N;
                int ny = (M + cur.y + dy[i]) % M;

                if (map[nx][ny] == 1) {
                    continue;
                }

                map[nx][ny] = 1;
                deque.add(new Pos(nx, ny));

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
        answer = 0;
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 1) {
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