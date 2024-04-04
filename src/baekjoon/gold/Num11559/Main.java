package baekjoon.gold.Num11559;

import java.io.*;
import java.util.*;

public class Main {
    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int ROW = 12;
    private static final int COL = 6;
    static char[][] map;
    static boolean[][] visited;
    static List<Pos> list;

    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static Deque<Pos> deque;

    static int helper() {
        int result = 0;
        boolean flag = true;

        while (flag) {
            flag = false;
            for (int i = 0; i < ROW; i++) {

                for (int j = 0; j < COL; j++) {
                    if (map[i][j] != '.') {
                        bfs(i, j);

                        if (list.size() >= 4) {
                            remove();
                            flag = true;
                        }
                    }
                }
            }
            down();

            if (flag) {
                result++;
            }

        }

        return result;
    }

    static void remove() {
        for (Pos pos : list) {
            map[pos.x][pos.y] = '.';
        }
    }

    static void bfs(int x, int y) {
        char word = map[x][y];
        deque = new ArrayDeque<>();
        list = new ArrayList<>();
        visited = new boolean[ROW][COL];

        deque.add(new Pos(x, y));
        list.add(new Pos(x, y));
        visited[x][y] = true;

        while (!deque.isEmpty()) {
            Pos cur = deque.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx > ROW - 1 || ny < 0 || ny > COL - 1 || map[nx][ny] != word || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                list.add(new Pos(nx, ny));
                deque.add(new Pos(nx, ny));
            }
        }
    }

    static void down() {
        Deque<Character> stack = new ArrayDeque<>();
        for (int j = 0; j < COL; j++) {
            for (int i = 0; i < ROW; i++) {
                if (map[i][j] != '.') {
                    stack.push(map[i][j]);
                }
                map[i][j] = '.';
            }

            int index = ROW - 1;
            while (!stack.isEmpty()) {
                map[index--][j] = stack.pop();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new char[ROW][COL];

        for (int i = 0; i < ROW; i++) {
            map[i] = br.readLine().toCharArray();
        }
        bw.write(String.valueOf(helper()));
        br.close();
        bw.close();
    }
}