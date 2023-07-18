package baekjoon.silver.Num21736;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int answer;
    static int[][] arr;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static Queue<int[]> q = new LinkedList<>();

    public static void helper() {

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < dx.length; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1 || arr[nx][ny] == 'X') {
                    continue;
                }
                if (arr[nx][ny] == 'P') {
                    answer++;
                }
                arr[nx][ny] = 'X';
                q.add(new int[]{nx, ny});
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = ch[j];

                if (ch[j] == 'I') {
                    q.add(new int[]{i, j});
                }
            }
        }

        answer = 0;
        helper();
        bw.write(answer == 0 ? "TT" : answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
