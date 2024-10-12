package baekjoon.gold.Num01941;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    private static final int SIZE = 5;
    static char[][] map;
    static int answer;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static boolean[][] selected, visited;

    static boolean bfs(int sx, int sy) {

        Deque<Point> deque = new ArrayDeque<>();
        int connectedCount = 1;
        visited = new boolean[SIZE][SIZE];
        deque.add(new Point(sx, sy));
        visited[sx][sy] = true;

        while (!deque.isEmpty()) {
            Point cur = deque.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx > SIZE - 1 || ny < 0 || ny > SIZE - 1 || visited[nx][ny] || !selected[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                connectedCount++;
                deque.add(new Point(nx, ny));

            }
        }

        return connectedCount == 7;
    }

    static boolean check() {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (selected[i][j]) {
                    return bfs(i, j);
                }
            }
        }
        return false;
    }

    static void dfs(int depth, int count, int sCount) {

        if (count > 7) {
            return;
        }

        if (depth == 25) {
            if (count == 7 && sCount >= 4) {
                answer += check() ? 1 : 0;
            }
            return;
        }

        selected[depth / 5][depth % 5] = true;
        dfs(depth + 1, count + 1, sCount + (map[depth / 5][depth % 5] == 'S' ? 1 : 0));
        selected[depth / 5][depth % 5] = false;
        dfs(depth + 1, count, sCount);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new char[SIZE][SIZE];
        selected = new boolean[SIZE][SIZE];
        answer = 0;
        for (int i = 0; i < SIZE; i++) {
            map[i] = br.readLine().toCharArray();
        }

        dfs(0, 0, 0);

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}