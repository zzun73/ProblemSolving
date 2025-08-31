package baekjoon.silver.Num02823;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static int helper() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == 'X') {
                    continue;
                }

                int count = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = r + dx[d];
                    int nc = c + dy[d];
                    if (nr < 0 || nr > R - 1 || nc < 0 || nc > C - 1 || map[nr][nc] == 'X') {
                        continue;
                    }
                    count++;
                }

                if (count <= 1) {
                    return 1;
                }
            }
        }

        return 0;
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
            map[i] = br.readLine().toCharArray();
        }
        bw.write(String.valueOf(helper()));

        br.close();
        bw.close();
    }
}