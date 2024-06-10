package baekjoon.silver.Num16948;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Point {
    int x, y, cost;

    public Point(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}

public class Main {
    static int N, r1, c1, r2, c2;
    static Deque<Point> deque;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};
    static boolean[][] visited;

    static int helper() {
        deque.addFirst(new Point(r1, c1, 0));
        visited[r1][c1] = true;
        while (!deque.isEmpty()) {
            Point cur = deque.poll();
            int x = cur.x;
            int y = cur.y;
            int c = cur.cost;

            if (x == r2 && y == c2) {
                return c;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1 || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                deque.add(new Point(nx, ny, c + 1));
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        visited = new boolean[N][N];
        deque = new ArrayDeque<>();

        bw.write(String.valueOf(helper()));

        br.close();
        bw.close();
    }
}