package baekjoon.gold.Num23352;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int x, y, len;

        public Point(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }

    static int N, M, answerSum, answerLen, pathSum, pathLen;
    static int[][] map, distance;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static Deque<Point> deque;
    static boolean[][] visited;

    static void helper(int sx, int sy) {
        deque.add(new Point(sx, sy, 1));
        visited = new boolean[N][M];
        visited[sx][sy] = true;
        int maxDistance = 0;
        int ex = 0, ey = 0;
        while (!deque.isEmpty()) {
            Point cur = deque.poll();
            if (maxDistance < cur.len) {
                maxDistance = cur.len;
                ex = cur.x;
                ey = cur.y;
            } else if (maxDistance == cur.len && map[cur.x][cur.y] > map[ex][ey]) {
                ex = cur.x;
                ey = cur.y;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1 || map[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                distance[nx][ny] = cur.len + 1;
                deque.add(new Point(nx, ny, cur.len + 1));
            }
        }


        pathSum = map[sx][sy] + map[ex][ey];
        pathLen = maxDistance;

        if (pathLen > answerLen) {
            answerLen = pathLen;
            answerSum = pathSum;
        } else if (pathLen == answerLen) {
            answerSum = Math.max(answerSum, pathSum);
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
        visited = new boolean[N][M];
        distance = new int[N][M];
        deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    helper(i, j);
                }
            }
        }

        bw.write(String.valueOf(answerSum));
        br.close();
        bw.close();
    }
}