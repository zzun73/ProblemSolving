package baekjoon.silver.Num05958;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, answer;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    static void helper(int x, int y) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.push(new int[]{x, y});
        visited[x][y] = true;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1 || visited[nx][ny] || map[nx][ny] == '.') {
                    continue;
                }
                visited[nx][ny] = true;
                map[nx][ny] = '.';
                deque.add(new int[]{nx, ny});
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '*' && !visited[i][j]) {
                    helper(i, j);
                    answer++;
                }
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}