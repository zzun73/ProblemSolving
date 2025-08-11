package baekjoon.silver.Num17198;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static Deque<int[]> deque;
    static char[][] map;
    static boolean[][] visited;
    static int answer;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    static void helper() {

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            if (map[cur[0]][cur[1]] == 'L') {
                answer = cur[2];
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx > 9 || ny < 0 || ny > 9 || visited[nx][ny] || map[nx][ny] == 'R') {
                    continue;
                }

                deque.add(new int[]{nx, ny, cur[2] + 1});
                visited[nx][ny] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        answer = 0;
        map = new char[10][10];
        deque = new ArrayDeque<>();
        visited = new boolean[10][10];

        for (int i = 0; i < 10; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < 10; j++) {
                map[i][j] = input[j];
                if (map[i][j] == 'B') {
                    deque.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        helper();

        bw.write(String.valueOf(answer - 1));

        br.close();
        bw.close();
    }
}