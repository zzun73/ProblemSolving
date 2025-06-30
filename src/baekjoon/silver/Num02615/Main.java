package baekjoon.silver.Num02615;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final int SIZE = 19;
    static int[][] map;
    static int[][] direction = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}};

    static boolean helper(int x, int y, int d) {
        int stone = map[x][y];

        int px = x - direction[d][0];
        int py = y - direction[d][1];
        if (isIn(px, py) && map[px][py] == stone) {
            return false;
        }

        for (int k = 1; k < 5; k++) {
            int nx = x + direction[d][0] * k;
            int ny = y + direction[d][1] * k;
            if (!isIn(nx, ny) || map[nx][ny] != stone) {
                return false;
            }
        }

        int ex = x + direction[d][0] * 5;
        int ey = y + direction[d][1] * 5;
        return !(isIn(ex, ey) && map[ex][ey] == stone);
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        map = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                for (int k = 0; k < direction.length; k++) {
                    if (map[i][j] != 0 && helper(i, j, k)) {
                        sb.append(map[i][j]).append("\n").append(i + 1).append(" ").append(j + 1);
                        bw.write(sb.toString());
                        bw.close();
                        return;
                    }
                }
            }
        }
        bw.write("0");

        br.close();
        bw.close();
    }
}