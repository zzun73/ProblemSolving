package baekjoon.silver.Num26533;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int n;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    static boolean bfs() {
        Deque<int[]> deque = new ArrayDeque<>();
        if (map[0][0] == 'x') {
            return false;
        }

        deque.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int x = cur[0], y = cur[1];

            if (x == n - 1 && y == n - 1) {
                return true;
            }

            for (int d = 0; d < 2; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < n && ny < n && !visited[nx][ny] && map[nx][ny] == '.') {
                    visited[nx][ny] = true;
                    deque.add(new int[]{nx, ny});
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine().trim());
        map = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        bw.write(bfs() ? "Yes" : "No");

        br.close();
        bw.close();
    }
}