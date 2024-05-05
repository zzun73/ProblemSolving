package baekjoon.gold.Num18405;

import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
    int type, x, y, time;

    public Point(int type, int x, int y, int time) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.time = time;
    }

    @Override
    public int compareTo(Point o) {
        return this.type - o.type;
    }
}

public class Main {
    static int N, K, S, X, Y;
    static int[][] map;
    static boolean[][] visited;
    static Deque<Point> deque;
    static List<Point> list;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    static void helper() {
        while (!deque.isEmpty()) {
            Point cur = deque.poll();

            if (cur.time == S) {
                return;
            }

            int x = cur.x;
            int y = cur.y;

            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1 || visited[nx][ny] || map[nx][ny] != 0) {
                    continue;
                }
                map[nx][ny] = cur.type;
                deque.add(new Point(cur.type, nx, ny, cur.time + 1));
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        deque = new ArrayDeque<>();
        list = new ArrayList<>();
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    list.add(new Point(map[i][j], i, j, 0));
                }
            }
        }
        Collections.sort(list);
        deque.addAll(list);

        st = new StringTokenizer(br.readLine(), " ");
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;
        Y = Integer.parseInt(st.nextToken()) - 1;

        helper();

        bw.write(String.valueOf(map[X][Y]));

        br.close();
        bw.close();
    }
}