package programmers.level2.Num1844;

import java.util.*;

class Solution {
    static class Point {
        int x, y, cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    static int helper(int[][] map) {
        Deque<Point> deque = new ArrayDeque<>();
        int N = map.length;
        int M = map[0].length;

        deque.add(new Point(0, 0, 1));

        while (!deque.isEmpty()) {
            Point cur = deque.poll();
            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.cost;
            }
            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1 || map[nx][ny] == 0) {
                    continue;
                }
                map[nx][ny] = 0;
                deque.add(new Point(nx, ny, cur.cost + 1));
            }
        }

        return -1;
    }

    public int solution(int[][] maps) {
        return helper(maps);
    }
}