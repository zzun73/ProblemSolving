package baekjoon.silver.Num09365;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void helper(int sx, int sy) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{sx, sy});
        visited[sx][sy] = true;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 1 || ny < 1 || nx > R || ny > C || visited[nx][ny] || map[nx][ny] < map[x][y]) {
                    continue;
                }

                visited[nx][ny] = true;
                deque.add(new int[]{nx, ny});
            }
        }
    }

    static boolean isBoundary(int x, int y) {
        return (x == 1 || y == 1 || x == R || y == C);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            map = new int[R + 1][C + 1];
            visited = new boolean[R + 1][C + 1];
            for (int i = 1; i <= R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= C; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            helper(A, B);

            int count = 0;
            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    if (visited[i][j] && isBoundary(i, j)) {
                        count++;
                    }
                }
            }

            sb.append("Case #").append(t).append(": ").append(count).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}