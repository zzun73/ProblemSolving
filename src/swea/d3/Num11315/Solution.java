package swea.d3.Num11315;

import java.io.*;

public class Solution {
    static int N;
    static int[] dx = {0, 1, 1, 1};
    static int[] dy = {1, 0, 1, -1};

    static char[][] board;

    public static boolean helper() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < dx.length; k++) {
                    int cnt = 0;
                    int nx = i;
                    int ny = j;
                    while (nx < N && nx >= 0 && ny < N && ny >= 0 && board[nx][ny] == 'o') {
                        cnt++;
                        nx += dx[k];
                        ny += dy[k];
                    }

                    if (cnt >= 5) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            board = new char[N][N];

            for (int i = 0; i < N; i++) {
                char[] row = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    board[i][j] = row[j];
                }
            }

            sb.append("#").append(t).append(" ").append(helper() ? "YES" : "NO").append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}