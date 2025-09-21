package baekjoon.gold.Num17836;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M, T;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};


    static class Point {
        int x, y, time, isSword;

        public Point(int x, int y, int time, int isSword) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.isSword = isSword;
        }
    }

    static int helper() {
        Deque<Point> deque = new ArrayDeque<>();
        deque.add(new Point(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!deque.isEmpty()) {
            Point cur = deque.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.time;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1) {
                    continue;
                }

                int nSword = map[nx][ny] == 2 || cur.isSword == 1 ? 1 : 0;

                if (visited[nx][ny][nSword]) {
                    continue;
                }

                if (nSword == 1) {
                    deque.add(new Point(nx, ny, cur.time + 1, nSword));
                    visited[nx][ny][nSword] = true;
                } else {
                    if (map[nx][ny] != 1) {
                        deque.add(new Point(nx, ny, cur.time + 1, nSword));
                        visited[nx][ny][nSword] = true;
                    }
                }

            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = helper();
        bw.write(String.valueOf(result > T ? "Fail" : result));

        br.close();
        bw.close();
    }
}