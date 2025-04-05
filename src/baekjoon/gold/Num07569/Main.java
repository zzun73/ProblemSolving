package baekjoon.gold.Num07569;

import java.io.*;
import java.util.*;

public class Main {
    static int H, N, M, targetCount;
    static int[][][] map;
    static Deque<int[]> deque;
    static int[] dx = new int[]{1, -1, 0, 0, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1, 0, 0};
    static int[] dz = new int[]{0, 0, 0, 0, 1, -1};

    static int helper() {
        int day = 0;
        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            day = Math.max(day, cur[3]);

            for (int i = 0; i < dx.length; i++) {
                int nz = cur[0] + dz[i];
                int ny = cur[1] + dy[i];
                int nx = cur[2] + dx[i];
                if (nx < 0 || nx > M - 1 || ny < 0 || ny > N - 1 || nz < 0 || nz > H - 1 || map[nz][ny][nx] != 0) {
                    continue;
                }
                targetCount--;
                map[nz][ny][nx] = -1;
                deque.add(new int[]{nz, ny, nx, cur[3] + 1});
            }
        }

        return targetCount == 0 ? day : -1;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        deque = new ArrayDeque<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());

                    if (map[i][j][k] == 1) {
                        deque.add(new int[]{i, j, k, 0});
                        map[i][j][k] = -1;
                    }
                    if (map[i][j][k] == 0) {
                        targetCount++;
                    }
                }
            }
        }

        sb.append(targetCount == 0 ? 0 : helper());

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
