package baekjoon.silver.Num24449;

import java.awt.*;
import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int x;
        int y;
        int distance;
        boolean flag;

        public Point(int x, int y, int distance, boolean flag) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.flag = flag;
        }
    }

    static int H, W;
    static char[][] map;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    static int helper() {
        Deque<Point> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[H][W];

        visited[0][0] = true;
        deque.add(new Point(0, 0, 0, check(0, 0)));


        while (!deque.isEmpty()) {
            Point cur = deque.poll();
            if (cur.x == H - 1 && cur.y == W - 1) {
                return cur.distance;
            }
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || nx > H - 1 || ny < 0 || ny > W - 1
                        || visited[nx][ny] || check(nx, ny) == check(cur.x, cur.y)) {
                    continue;
                }
                deque.add(new Point(nx, ny, cur.distance + 1, check(nx, ny)));
                visited[nx][ny] = true;
            }
        }

        return -1;
    }

    static boolean check(int x, int y) {
        return map[x][y] == '#';
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new char[H][W];

        for (int i = 0; i < H; i++) {
            map[i] = br.readLine().toCharArray();
        }

        bw.write(String.valueOf(helper()));

        br.close();
        bw.close();
    }
}