package baekjoon.silver.Num06189;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static int R, C, sx, sy, ex, ey;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int helper() {
        Deque<int[]> deque = new ArrayDeque<>();

        deque.add(new int[]{sx, sy, 0});
        map[sx][sy] = '*';

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int x = cur[0];
            int y = cur[1];
            int weight = cur[2];
            if (x == ex && y == ey) {
                return weight;
            }

            for (int d = 0; d < dx.length; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx > R - 1 || ny < 0 || ny > C - 1 || map[nx][ny] == '*') {
                    continue;
                }

                map[nx][ny] = '*';
                deque.add(new int[]{nx, ny, weight + 1});
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = input[j];
                if (map[i][j] == 'C') {
                    sx = i;
                    sy = j;
                } else if (map[i][j] == 'B') {
                    ex = i;
                    ey = j;
                }
            }
        }

        bw.write(String.valueOf(helper()));

        br.close();
        bw.close();
    }
}