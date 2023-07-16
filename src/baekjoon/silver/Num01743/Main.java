package baekjoon.silver.Num01743;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public static int helper(int x, int y) {
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < dx.length; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1 || arr[nx][ny] == 0) {
                    continue;
                }
                arr[nx][ny] = 0;
                q.add(new int[]{nx, ny});
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            arr[x][y] = 1;
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    answer = Math.max(answer, helper(i, j));
                }
            }
        }
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
