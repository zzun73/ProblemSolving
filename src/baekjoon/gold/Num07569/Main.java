package baekjoon.gold.Num07569;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H;
    static int[][][] arr;
    static int[] dz = new int[]{0, 0, 0, 0, 1, -1};
    static int[] dy = new int[]{0, 0, 1, -1, 0, 0};
    static int[] dx = new int[]{1, -1, 0, 0, 0, 0};
    static Queue<int[]> q = new LinkedList<>();

    public static int helper() {

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curZ = cur[0];
            int curY = cur[1];
            int curX = cur[2];

            for (int i = 0; i < dx.length; i++) {
                int nz = curZ + dz[i];
                int ny = curY + dy[i];
                int nx = curX + dx[i];

                if (nz < 0 || nz > H - 1 || ny < 0 || ny > N - 1 || nx < 0 || nx > M - 1 || arr[nz][ny][nx] != 0) {
                    continue;
                }
                arr[nz][ny][nx] = arr[curZ][curY][curX] + 1;
                q.add(new int[]{nz, ny, nx});
            }
        }

        int count = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 0) {
                        return -1;
                    }
                    count = Math.max(count, arr[i][j][k]);
                }
            }
        }
        return count - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < M; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());

                    if (arr[i][j][k] == 1) {
                        q.add(new int[]{i, j, k});
                    }
                }
            }
        }

        int answer;
        answer = helper();
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
