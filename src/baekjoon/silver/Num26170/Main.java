package baekjoon.silver.Num26170;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final int SIZE = 5;
    static int answer;
    static int[][] map;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    static void helper(int depth, int x, int y, int count) {
        if (count == 3) {
            answer = Math.min(depth, answer);
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > SIZE - 1 || ny < 0 || ny > SIZE - 1 || map[nx][ny] == -1) {
                continue;
            }
            int val = map[nx][ny];
            map[nx][ny] = -1;

            if (val == 1) {
                helper(depth + 1, nx, ny, count + 1);
            } else {
                helper(depth + 1, nx, ny, count);
            }
            map[nx][ny] = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        map = new int[SIZE][SIZE];
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int cnt = 0;
        if (map[sx][sy] == 1) {
            cnt++;
        }
        map[sx][sy] = -1;
        helper(0, sx, sy, cnt);

        bw.write(String.valueOf(answer == Integer.MAX_VALUE ? -1 : answer));

        br.close();
        bw.close();
    }
}