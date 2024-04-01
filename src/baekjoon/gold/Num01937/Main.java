package baekjoon.gold.Num01937;

import java.io.*;
import java.util.*;

public class Main {
    static int N, answer;
    static int[][] map, memo;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    static int dfs(int x, int y) {
        if (memo[x][y] > 0) {
            return memo[x][y];
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1 || map[x][y] >= map[nx][ny]) {
                continue;
            }

            memo[x][y] = Math.max(1 + dfs(nx, ny), memo[x][y]);
        }
        return memo[x][y];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        memo = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (memo[i][j] == 0) {
                    answer = Math.max(answer, 1 + dfs(i, j));
                }
            }
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}
