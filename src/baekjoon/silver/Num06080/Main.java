package baekjoon.silver.Num06080;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int[][] arr;
    static int[] dx = new int[]{-1, 0, 1, 0, 1, 1, -1, -1};
    static int[] dy = new int[]{0, 1, 0, -1, -1, 1, -1, 1};

    static void helper(int sx, int sy) {
        Deque<int[]> deque = new ArrayDeque<>();
        arr[sx][sy] = 0;
        deque.add(new int[]{sx, sy});
        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C || arr[nx][ny] == 0) {
                    continue;
                }
                arr[nx][ny] = 0;
                deque.add(new int[]{nx, ny});
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

        arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] > 0) {
                    helper(i, j);
                    answer++;
                }
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}