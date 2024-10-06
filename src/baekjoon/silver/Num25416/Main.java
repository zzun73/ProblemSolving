package baekjoon.silver.Num25416;

import java.io.*;
import java.util.*;

public class Main {
    private static final int SIZE = 5;

    static int r, c, answer = -1;
    static int[][] map;
    static int[] dx = new int[] { 1, -1, 0, 0 };
    static int[] dy = new int[] { 0, 0, 1, -1 };
    static boolean[][] visited;

    static void helper() {
        Deque<int[]> deque = new ArrayDeque<>();

        deque.add(new int[] { r, c, 0 });
        visited[r][c] = true;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            if (map[cur[0]][cur[1]] == 1) {
                answer = cur[2];
                return;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx > SIZE - 1 || ny < 0 || ny > SIZE - 1 || visited[nx][ny] || map[nx][ny] == -1) {
                    continue;
                }

                visited[nx][ny] = true;
                deque.add(new int[] { nx, ny, cur[2] + 1 });
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        map = new int[SIZE][SIZE];
        visited = new boolean[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        helper();

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}