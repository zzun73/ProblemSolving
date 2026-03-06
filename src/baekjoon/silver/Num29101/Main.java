package baekjoon.silver.Num29101;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] board;
    static int[] dx = new int[]{0, 1, 1, 1};
    static int[] dy = new int[]{1, 0, 1, -1};

    static boolean helper(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int count = 1;

            for (int k = 1; k < 5; k++) {
                int nx = x + (dx[d] * k);
                int ny = y + (dy[d] * k);

                if (isOut(nx, ny) || board[nx][ny] != board[x][y]) {
                    break;
                }
                count++;
            }
            if (count >= 5) {
                return true;
            }
        }
        return false;
    }

    static boolean isOut(int x, int y) {
        return x < 0 || x > N - 1 || y < 0 || y > M - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != '.' && helper(i, j)) {
                    bw.write("Yes");
                    bw.flush();
                    return;
                }
            }
        }
        bw.write("No");

        br.close();
        bw.close();
    }
}