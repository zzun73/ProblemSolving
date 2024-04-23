package baekjoon.gold.Num16469;

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

    static int R, C;
    static int[][] map;
    static int[][][] count;
    static Deque<Pos> deque;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    static void helper(int num, int sx, int sy) {
        boolean[][] visited = new boolean[R + 1][C + 1];
        count[num][sx][sy] = 1;

        deque.add(new Pos(sx, sy));
        visited[sx][sy] = true;

        while (!deque.isEmpty()) {
            Pos cur = deque.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx <= 0 || nx > R || ny <= 0 || ny > C || visited[nx][ny] || map[nx][ny] == 1) {
                    continue;
                }
                visited[nx][ny] = true;
                deque.add(new Pos(nx, ny));
                count[num][nx][ny] = count[num][cur.x][cur.y] + 1;
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        deque = new ArrayDeque<>();
        map = new int[R + 1][C + 1];
        count = new int[3][R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 1; j <= C; j++) {
                map[i][j] = row[j - 1] - '0';
            }
        }

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            helper(i, sx, sy);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (count[0][i][j] > 0 && count[1][i][j] > 0 && count[2][i][j] > 0) {
                    int val = Math.max(Math.max(count[0][i][j], count[1][i][j]), count[2][i][j]);
                    list.add(val);
                }
            }
        }
        if (list.isEmpty()) {
            sb.append("-1");
        } else {
            Collections.sort(list);
            int min = list.get(0);
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                if (min != list.get(i)) {
                    break;
                }
                count++;
            }
            sb.append(min - 1).append("\n").append(count);
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

}