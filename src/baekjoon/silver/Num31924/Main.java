package baekjoon.silver.Num31924;

import java.io.*;

public class Main {
    static int N, answer;
    static int[][] direction = new int[][]{
            {0, 1}, {1, 0}, {0, -1}, {-1, 0},
            {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    static char[][] map;

    static void helper(int depth, int x, int y, int dir, StringBuilder cur) {
        if (depth == 5) {
            if (cur.toString().equals("MOBIS")) {
                answer++;
            }
            return;
        }

        if (isIn(x + direction[dir][0], y + direction[dir][1])) {
            cur.append(map[x + direction[dir][0]][y + direction[dir][1]]);
            helper(depth + 1, x + direction[dir][0], y + direction[dir][1], dir, cur);
        }
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        answer = 0;

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'M') {
                    for (int k = 0; k < direction.length; k++) {
                        sb.append(map[i][j]);
                        helper(1, i, j, k, sb);
                        sb.setLength(0);
                    }
                }
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}