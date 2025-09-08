package baekjoon.gold.Num16954;

import java.io.*;
import java.util.*;

public class Main {
    private static final int SIZE = 8;
    static char[][] map;
    static int[] dx = new int[]{0, 1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = new int[]{0, 0, 1, 1, 1, 0, -1, -1, -1};
    static boolean[][] visited;

    static int helper() {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{SIZE - 1, 0});

        while (!deque.isEmpty()) {
            int size = deque.size();
            visited = new boolean[SIZE][SIZE];

            while (size-- > 0) {
                int[] cur = deque.poll();
                int x = cur[0];
                int y = cur[1];
                if (map[x][y] == '#') {
                    continue;
                }

                if (x == 0 && y == SIZE - 1) {
                    return 1;
                }

                for (int i = 0; i < 9; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (isGo(nx, ny)) {
                        deque.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            down();
        }

        return 0;
    }

    static void down() {
        for (int i = SIZE - 1; i > 0; i--) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = map[i - 1][j];
            }
        }
        Arrays.fill(map[0], '.');
    }


    static boolean isGo(int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE && map[x][y] != '#' && !visited[x][y];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            map[i] = br.readLine().toCharArray();
        }

        bw.write(String.valueOf(helper()));

        br.close();
        bw.close();
    }
}