package baekjoon.silver.Num29634;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static char[][] map;
    static Deque<Pos> deque;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    static int helper(int sx, int sy) {

        int count = 1;
        deque.add(new Pos(sx, sy));
        map[sx][sy] = '*';
        while (!deque.isEmpty()) {
            Pos cur = deque.poll();

            int x = cur.x;
            int y = cur.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1 || map[nx][ny] == '*') {
                    continue;
                }
                count++;
                map[nx][ny] = '*';
                deque.add(new Pos(nx, ny));
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        deque = new ArrayDeque<>();
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '.') {
                    answer = Math.max(answer, helper(i, j));
                }
            }
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}