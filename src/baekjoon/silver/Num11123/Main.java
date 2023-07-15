package baekjoon.silver.Num11123;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static char[][] grid;
    static int N, M;

    public static void helper(int x, int y) {
        grid[x][y] = '.';

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1 || grid[nx][ny] == '.') {
                continue;
            }
            helper(nx, ny);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            grid = new char[N][M];
            for (int i = 0; i < N; i++) {
                char[] ch = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    grid[i][j] = ch[j];
                }
            }

            int answer = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (grid[i][j] == '#') {
                        helper(i, j);
                        answer++;
                    }
                }
            }
            bw.write(answer + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
