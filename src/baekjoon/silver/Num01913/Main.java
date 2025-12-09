package baekjoon.silver.Num01913;

import java.io.*;

public class Main {
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int targetNumber = Integer.parseInt(br.readLine());

        int num = N * N;
        int[][] arr = new int[N][N];

        int cx = 0;
        int cy = 0;
        int dir = 0;
        int targetX = 0, targetY = 0;

        while (num > 0) {
            if (num == targetNumber) {
                targetX = cx + 1;
                targetY = cy + 1;
            }

            arr[cx][cy] = num--;

            int nx = cx + dx[dir];
            int ny = cy + dy[dir];

            if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1 || arr[nx][ny] != 0) {
                dir = (dir + 1) % 4;
                cx += dx[dir];
                cy += dy[dir];
            } else {
                cx = nx;
                cy = ny;
            }
        }

        for (int[] row : arr) {
            for (int val : row) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        sb.append(targetX).append(" ").append(targetY);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}