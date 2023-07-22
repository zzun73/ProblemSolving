package baekjoon.silver.Num07562;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int l;
    static int[] dx = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = new int[]{-2, -1, 1, 2, -2, -1, 1, 2};
    static Pos end;

    private static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    private static int helper(int[][] board, Pos start) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(start);
        board[start.x][start.y] = 1;
        while (!queue.isEmpty()) {
            Pos cur = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx > l - 1 || ny < 0 || ny > l - 1 || board[nx][ny] != 0) {
                    continue;
                }
                board[nx][ny] = board[cur.x][cur.y] + 1;
                queue.add(new Pos(nx, ny));
                if (nx == end.x && ny == end.y) {
                    return board[nx][ny] - 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            l = Integer.parseInt(br.readLine());
            int[][] board = new int[l][l];

            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            Pos start = new Pos(a, b);
            end = new Pos(c, d);

            int answr = helper(board, start);
            bw.write(answr + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
