package baekjoon.gold.Num13460;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, answer;
    static char[][] map;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static Ball startBall;

    static class Ball {
        int rx, ry, bx, by, count;

        public Ball() {
        }

        public Ball(int rx, int ry, int bx, int by, int count) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.count = count;
        }

    }

    static void helper() {
        Deque<Ball> deque = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[N][M][N][M];
        visited[startBall.rx][startBall.ry][startBall.bx][startBall.by] = true;
        deque.add(startBall);

        while (!deque.isEmpty()) {
            Ball cur = deque.poll();

            if (cur.count >= 10) {
                continue;
            }

            for (int d = 0; d < dx.length; d++) {

                int rnx = cur.rx;
                int rny = cur.ry;
                int bnx = cur.bx;
                int bny = cur.by;
                boolean redIn = false;
                boolean blueIn = false;

                while (map[rnx + dx[d]][rny + dy[d]] != '#') {
                    rnx += dx[d];
                    rny += dy[d];

                    if (map[rnx][rny] == 'O') {
                        redIn = true;
                        break;
                    }
                }

                while (map[bnx + dx[d]][bny + dy[d]] != '#') {
                    bnx += dx[d];
                    bny += dy[d];

                    if (map[bnx][bny] == 'O') {
                        blueIn = true;
                        break;
                    }
                }

                if (blueIn) {
                    continue;
                }
                if (redIn) {
                    answer = Math.min(answer, cur.count + 1);
                    return;
                }

                if (rnx == bnx && rny == bny) {
                    int redMove = Math.abs(cur.rx - rnx) + Math.abs(cur.ry - rny);
                    int blueMove = Math.abs(cur.bx - bnx) + Math.abs(cur.by - bny);
                    if (redMove > blueMove) {
                        rnx -= dx[d];
                        rny -= dy[d];

                    } else {
                        bnx -= dx[d];
                        bny -= dy[d];

                    }
                }

                if (!visited[rnx][rny][bnx][bny]) {
                    visited[rnx][rny][bnx][bny] = true;
                    deque.add(new Ball(rnx, rny, bnx, bny, cur.count + 1));
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
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        startBall = new Ball();
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = row[j];
                if (map[i][j] == 'R') {
                    startBall.rx = i;
                    startBall.ry = j;
                } else if (map[i][j] == 'B') {
                    startBall.bx = i;
                    startBall.by = j;
                }
            }
        }

        helper();

        bw.write(String.valueOf(answer == Integer.MAX_VALUE ? -1 : answer));

        br.close();
        bw.close();
    }
}
