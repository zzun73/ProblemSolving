package baekjoon.gold.Num21772;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int R, C, T, sx, sy, answer;
    static char[][] map;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static void helper(int time, int count, int x, int y) {
        if (time == T) {
            answer = Math.max(answer, count);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx > R - 1 || ny < 0 || ny > C - 1 || map[nx][ny] == '#') {
                continue;
            }

            if (map[nx][ny] == 'S') {
                map[nx][ny] = '.';
                helper(time + 1, count + 1, nx, ny);
                map[nx][ny] = 'S';
            } else {
                helper(time + 1, count, nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = row[j];
                if (map[i][j] == 'G') {
                    sx = i;
                    sy = j;
                }
            }
        }

        helper(0, 0, sx, sy);

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}