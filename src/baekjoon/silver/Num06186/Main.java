package baekjoon.silver.Num06186;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] board;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void helper(int x, int y) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{x, y});
        board[x][y] = '.';
        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx > R - 1 || ny < 0 || ny > C - 1 || board[nx][ny] == '.') {
                    continue;
                }
                board[nx][ny] = '.';
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
        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                board[i][j] = ch[j];
            }
        }

        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == '#') {
                    helper(i, j);
                    answer++;
                }
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}