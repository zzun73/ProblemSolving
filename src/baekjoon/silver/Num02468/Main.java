package baekjoon.silver.Num02468;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void helper(int x, int y, int height) {
        visited[x][y] = true;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > arr.length - 1 || ny < 0 || ny > arr.length - 1 || visited[nx][ny] || arr[nx][ny] <= height) {
                continue;
            }
            helper(nx, ny, height);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        int height = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                height = Math.max(height, arr[i][j]);
            }
        }

        int answer = 0;
        for (int h = 0; h <= height; h++) {
            visited = new boolean[N][N];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && arr[i][j] > h) {
                        helper(i, j, h);
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
