package baekjoon.silver.Num17129;

import java.io.*;
import java.util.*;

class Pos {
    int x, y, distance;

    public Pos(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}

public class Main {
    static int n, m, sx, sy;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int[][] map;
    static Deque<Pos> deque;

    static int helper() {
        deque = new ArrayDeque<>();
        deque.add(new Pos(sx, sy, 0));
        map[sx][sy] = 1;

        while (!deque.isEmpty()) {
            Pos cur = deque.poll();
            int x = cur.x;
            int y = cur.y;
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1 || map[nx][ny] == 1) {
                    continue;
                }
                if (map[nx][ny] > 2) {
                    return cur.distance + 1;
                }
                map[nx][ny] = 1;
                deque.add(new Pos(nx, ny, cur.distance + 1));
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = row[j] - '0';
                if (map[i][j] == 2) {
                    sx = i;
                    sy = j;
                }
            }
        }
        int count = helper();
        sb.append(count > 0 ? "TAK" : "NIE").append("\n");
        if (count > 0) {
            sb.append(count);
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

}