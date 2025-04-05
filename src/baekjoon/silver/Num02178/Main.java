package baekjoon.silver.Num02178;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static int helper() {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0, 1});
        map[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            if (cur[0] == N - 1 && cur[1] == M - 1) {
                return cur[2];
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1 || map[nx][ny] == 0) {
                    continue;
                }
                map[nx][ny] = 0;
                deque.add(new int[]{nx, ny, cur[2] + 1});
            }
        }

        return -1;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = input[j] - '0';
            }
        }

        bw.write(String.valueOf(helper()));

        br.close();
        bw.close();
    }
}
