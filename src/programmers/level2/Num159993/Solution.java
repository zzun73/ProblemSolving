package programmers.level2.Num159993;

import java.util.*;

class Solution {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Point {
        int x, y, d;

        Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    int helper(int sx, int sy, char target) {
        visited = new boolean[N][M];
        Deque<Point> deque = new ArrayDeque<>();
        deque.offer(new Point(sx, sy, 0));
        visited[sx][sy] = true;

        while (!deque.isEmpty()) {
            Point cur = deque.poll();

            if (map[cur.x][cur.y] == target) {
                return cur.d;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 'X' || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                deque.offer(new Point(nx, ny, cur.d + 1));
            }
        }

        return -1;
    }

    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        map = new char[N][M];

        int sx = -1, sy = -1;
        int lx = -1, ly = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = maps[i].charAt(j);
                if (map[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if (map[i][j] == 'L') {
                    lx = i;
                    ly = j;
                }
            }
        }

        int toLever = helper(sx, sy, 'L');
        if (toLever == -1) {
            return -1;
        }

        int toExit = helper(lx, ly, 'E');
        if (toExit == -1) {
            return -1;
        }

        return toLever + toExit;
    }
}