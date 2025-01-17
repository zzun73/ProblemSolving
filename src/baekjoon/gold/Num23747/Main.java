package baekjoon.gold.Num23747;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int R, C, curR, curC;
    static char[][] visible;
    static char[][] map;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static void helper(char[] input) {

        for (char ch : input) {
            int moveCommand = move(ch);
            if (moveCommand == 4) {
                visible[curR][curC] = '.';
                installWard(map[curR][curC], curR, curC);
            } else {
                int nx = curR + dx[moveCommand];
                int ny = curC + dy[moveCommand];
                if (isOut(nx, ny)) {
                    continue;
                }
                curR = nx;
                curC = ny;
            }
        }

        visible[curR][curC] = '.';
        for (int i = 0; i < 4; i++) {
            int nx = curR + dx[i];
            int ny = curC + dy[i];
            if (isOut(nx, ny)) {
                continue;
            }
            visible[nx][ny] = '.';
        }
    }

    static void installWard(char target, int x, int y) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{x, y});

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (isOut(nx, ny) || map[nx][ny] != target || visible[nx][ny] == '.') {
                    continue;
                }
                visible[nx][ny] = '.';
                deque.add(new int[]{nx, ny});
            }
        }
    }

    static boolean isOut(int x, int y) {
        return !(x >= 0 && x < R && y >= 0 && y < C);
    }

    static int move(char command) {
        switch (command) {
            case 'U':
                return 0;
            case 'D':
                return 1;
            case 'L':
                return 2;
            case 'R':
                return 3;
            case 'W':
                return 4;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visible = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        st = new StringTokenizer(br.readLine(), " ");
        curR = Integer.parseInt(st.nextToken()) - 1;
        curC = Integer.parseInt(st.nextToken()) - 1;


        for (char[] row : visible) {
            Arrays.fill(row, '#');
        }

        helper(br.readLine().toCharArray());

        for (char[] row : visible) {
            for (char visited : row) {
                sb.append(visited);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}