package swea.d2.Num01954;

import java.io.*;

public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[] dir = new int[]{0, 1, 2, 3};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];

            int x, y, D;
            x = y = D = 0;
            arr[x][y] = 1;
            int nx, ny;
            for (int i = 2; i <= N * N; i++) {
                for (int j = 0; j < dir.length; j++) {
                    nx = x + dx[dir[D]];
                    ny = y + dy[dir[D]];
                    if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1 || arr[nx][ny] != 0) {
                        D = (D + 1) % 4;
                    } else {
                        arr[nx][ny] = i;
                        x = nx;
                        y = ny;
                        break;
                    }
                }
            }
            sb.append("#").append(t).append("\n");
            for (int[] rows : arr) {
                for (int val : rows) {
                    sb.append(val).append(" ");
                }
                sb.append("\n");
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}