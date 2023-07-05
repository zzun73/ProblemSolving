package baekjoon.gold.Num10026;

import java.io.*;

public class Main {
    static char[][] arr;
    static int N;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void helperV1(int x, int y, boolean[][] visited, char color) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1) {
                continue;
            }
            if (arr[nx][ny] == color && !visited[nx][ny]) {
                helperV1(nx, ny, visited, color);
            }
        }
    }

    public static void helperV2(int x, int y, boolean[][] visited, char color) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1) {
                continue;
            }
            char curColor = arr[nx][ny];
            if (color == 'B') {
                if (curColor == color && !visited[nx][ny]) {
                    helperV2(nx, ny, visited, color);
                }
            } else {
                if ((curColor == 'R' || curColor == 'G') && !visited[nx][ny]) {
                    helperV2(nx, ny, visited, color);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        boolean[][] visitedV1, visitedV2;
        visitedV1 = new boolean[N][N];
        visitedV2 = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                arr[i][j] = ch[j];
            }
//            if (N >= 0) System.arraycopy(ch, 0, arr[i], 0, N);
        }
        int countV1 = 0, countV2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visitedV1[i][j]) {
                    helperV1(i, j, visitedV1, arr[i][j]);
                    countV1++;
                }
                if (!visitedV2[i][j]) {
                    helperV2(i, j, visitedV2, arr[i][j]);
                    countV2++;
                }
            }
        }
        bw.write(countV1 + " " + countV2);

        br.close();
        bw.flush();
        bw.close();
    }
}
