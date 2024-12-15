package baekjoon.silver.Num09311;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int x, y, cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static int R, C, answer;
    static char[][] map;
    static boolean[][] visited;
    static Deque<Point> deque;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};


    static void helper() {
        while (!deque.isEmpty()) {
            Point cur = deque.poll();
            if (map[cur.x][cur.y] == 'G') {
                answer = cur.cost;
                return;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx > R - 1 || ny < 0 || ny > C - 1 || visited[nx][ny] || map[nx][ny] == 'X') {
                    continue;
                }
                visited[nx][ny] = true;
                deque.add(new Point(nx, ny, cur.cost + 1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new char[R][C];
            visited = new boolean[R][C];
            answer = 0;
            deque = new ArrayDeque<>();
            for (int i = 0; i < R; i++) {
                char[] input = br.readLine().toCharArray();
                for (int j = 0; j < C; j++) {
                    map[i][j] = input[j];
                    if (map[i][j] == 'S') {
                        visited[i][j] = true;
                        deque.add(new Point(i, j, 0));
                    }
                }
            }

            helper();

            if (answer == 0) {
                sb.append("No Exit");
            } else {
                sb.append("Shortest Path: ").append(answer);
            }
            sb.append("\n");

        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}