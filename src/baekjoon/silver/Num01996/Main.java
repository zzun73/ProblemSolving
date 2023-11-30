package baekjoon.silver.Num01996;

import java.io.*;

public class Main {
    static int N;
    static int[] dx = new int[]{0, -1, 0, 1, -1, -1, 1, 1};
    static int[] dy = new int[]{1, 0, -1, 0, 1, -1, 1, -1};
    static int[][] count;

    public static void helper(int x, int y, int val) {
        count[x][y] = -1;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1 || count[nx][ny] == -1) {
                continue;
            }
            count[nx][ny] += val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        count = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                char cur = ch[j];
                if (cur != '.') {
                    helper(i, j, cur - '0');
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (count[i][j] == -1) {
                    sb.append('*');
                } else if (count[i][j] >= 10) {
                    sb.append('M');
                } else {
                    sb.append(Character.forDigit(count[i][j], 10));
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}