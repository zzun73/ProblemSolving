package baekjoon.silver.Num26999;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static int N, M;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};


    static int helper(int x, int y) {
        Deque<int[]> deque = new ArrayDeque<>();
        int count = 0;
        deque.add(new int[]{x, y});
        map[x][y] = '.';
        count++;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (isOut(nx, ny) || map[nx][ny] != '*') {
                    continue;
                }

                deque.add(new int[]{nx, ny});
                map[nx][ny] = '.';
                count++;
            }
        }
        return count;
    }

    static boolean isOut(int nx, int ny) {
        return nx < 0 || nx >= M || ny < 0 || ny >= N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[M][N];

        for (int i = 0; i < M; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '*') {
                    answer = Math.max(helper(i, j), answer);
                }
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}