package baekjoon.gold.Num17142;

import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y, distance;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    private static final int BLANK = 0;
    private static final int WALL = 1;
    private static final int VIRUS = 2;
    static int N, M, answer, virusSize, blankSize;
    static int[][] map;
    static List<Point> virus;
    static boolean[] selected;
    static boolean[][] distance;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    static void choice(int start, int count) {
        if (count == M) {
            int res = bfs();
            if (res != -1) {
                answer = Math.min(answer, res);
            }
            return;
        }

        if (start > virusSize - (M - count)) {
            return;
        }

        for (int i = start; i < virusSize; i++) {
            selected[i] = true;
            choice(i + 1, count + 1);
            selected[i] = false;
        }
    }

    static int bfs() {
        Deque<Point> deque = new ArrayDeque<>();
        int curCount = 0;
        int result = 0;
        distance = new boolean[N][N];

        for (int i = 0; i < virus.size(); i++) {
            if (selected[i]) {
                int cx = virus.get(i).x, cy = virus.get(i).y;
                deque.add(new Point(cx, cy, 0));
                distance[cx][cy] = true;
            }
        }

        while (!deque.isEmpty()) {
            Point cur = deque.poll();
            int nd = cur.distance;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (isNotMove(nx, ny)) {
                    continue;
                }
                distance[nx][ny] = true;

                if (map[nx][ny] == VIRUS) {
                    deque.add(new Point(nx, ny, nd + 1));
                } else if (map[nx][ny] == BLANK) {
                    deque.add(new Point(nx, ny, nd + 1));
                    result = Math.max(result, nd + 1);

                    if (++curCount == blankSize) {
                        return result;
                    }
                }
            }
        }
        return curCount == blankSize ? result : -1;
    }

    static boolean isNotMove(int x, int y) {
        return x < 0 || x > N - 1 || y < 0 || y > N - 1 || distance[x][y] || map[x][y] == WALL;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = Integer.MAX_VALUE;
        virus = new ArrayList<>();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == VIRUS) {
                    virus.add(new Point(i, j));
                } else if (map[i][j] == BLANK) {
                    blankSize++;
                }
            }
        }

        virusSize = virus.size();
        selected = new boolean[virusSize];

        choice(0, 0);

        bw.write(String.valueOf(answer == Integer.MAX_VALUE ? -1 : answer));

        br.close();
        bw.close();
    }
}