package baekjoon.silver.Num15092;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m, n;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
    static int[] dy = {1, 0, -1, 1, 0, -1, 1, -1};

    public static void helper(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];
                if (nx < 0 || nx > m - 1 || ny < 0 || ny > n - 1 || board[nx][ny] == '.' || visited[nx][ny]) {
                    continue;
                }
                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new char[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                board[i][j] = ch[j];
            }
        }
        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == '#') {
                    helper(i, j);
                    answer++;
                }
            }
        }

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
