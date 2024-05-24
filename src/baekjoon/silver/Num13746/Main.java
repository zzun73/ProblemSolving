package baekjoon.silver.Num13746;

import java.io.*;
import java.util.*;


public class Main {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int r, c;
    static Deque<Point> deque;
    static boolean[][] visited;
    static char[][] map;

    static void helper(int sx, int sy) {
        deque.add(new Point(sx, sy));
        map[sx][sy] = 'W';
        while (!deque.isEmpty()) {
            Point cur = deque.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx > r - 1 || ny < 0 || ny > c - 1 || visited[nx][ny] || map[nx][ny] == 'W') {
                    continue;
                }
                visited[nx][ny] = true;
                map[nx][ny] = 'W';
                deque.add(new Point(nx, ny));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        deque = new ArrayDeque<>();
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && map[i][j] == 'L') {
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