package baekjoon.silver.Num02567;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        boolean[][] grid = new boolean[101][101];
        for (int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int i = x; i < x + 10; i++) {
                for (int j = y; j < y + 10; j++) {
                    grid[i][j] = true;
                }
            }
        }

        int answer = 0;
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid.length; j++) {
                if (grid[i][j]) {
                    for (int k = 0; k < dx.length; k++) {
                        int nx = dx[k] + i;
                        int ny = dy[k] + j;
                        if (!grid[nx][ny]) {
                            answer++;
                        }
                    }
                }
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}