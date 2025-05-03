package programmers.level2.Num154540;

import java.util.*;

class Solution {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int helper(int sx, int sy) {
        Deque<Point> deque = new ArrayDeque<>();
        deque.offer(new Point(sx, sy));
        visited[sx][sy] = true;
        int count = map[sx][sy];

        while (!deque.isEmpty()) {
            Point cur = deque.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }
                count += map[nx][ny];
                visited[nx][ny] = true;
                deque.offer(new Point(nx, ny));
            }
        }

        return count;
    }

    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i].charAt(j) == 'X') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = maps[i].charAt(j) - '0';
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    list.add(helper(i, j));
                }
            }
        }


        if (list.isEmpty()) {
            return new int[]{-1};
        } else {
            int[] answer = new int[list.size()];
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
            return answer;
        }

    }
}