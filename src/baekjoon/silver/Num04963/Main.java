package baekjoon.silver.Num04963;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int w, h;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
    static int[] dy = {0, 1, -1, 1, -1, 0, 1, -1};

    public static void helper(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > h - 1 || ny < 0 || ny > w - 1) {
                continue;
            }
            if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                helper(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }
            arr = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++) {
                    int v = Integer.parseInt(st.nextToken());
                    arr[i][j] = v;
                }
            }
            int answer = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        helper(i, j);
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
