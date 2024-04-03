package baekjoon.silver.Num26169;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final int SIZE = 5;

    static int r, c;
    static int[][] map;
    static boolean isPossible;
    static boolean[][] visited;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    static void helper(int depth, int count, int x, int y) {
        if (isPossible) {
            return;
        }
        if (count >= 2) {
            isPossible = true;
            return;
        }
        if (depth > 2) {
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > SIZE - 1 || ny < 0 || ny > SIZE - 1 || map[nx][ny] == -1 || visited[nx][ny]) {
                continue;
            }
            visited[nx][ny] = true;
            if (map[nx][ny] == 1) {
                helper(depth + 1, count + 1, nx, ny);
            } else {
                helper(depth + 1, count, nx, ny);
            }
            visited[nx][ny] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        map = new int[SIZE][SIZE];
        visited = new boolean[SIZE][SIZE];
        isPossible = false;
        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        if (map[r][c] == 0) {
            visited[r][c] = true;
            helper(0, 0, r, c);
        } else if (map[r][c] == 1) {
            visited[r][c] = true;
            helper(0, 1, r, c);
        }
        bw.write(isPossible ? "1" : "0");

        br.close();
        bw.close();
    }

}