package baekjoon.gold.Num01938;

import java.io.*;
import java.util.*;

public class Main {
    static class Pos {
        int x, y, dir, time;

        public Pos(int x, int y, int dir, int time) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.time = time;
        }
    }

    static int N, answer;
    static char[][] map;
    static boolean[][][] visited;
    static Deque<Pos> deque;
    static Pos B, E;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int[] hx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] hy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    static void helper() {
        visited = new boolean[2][N][N];
        deque = new ArrayDeque<>();
        deque.add(B);// 시작
        visited[B.dir][B.x][B.y] = true;

        while (!deque.isEmpty()) {
            Pos cur = deque.poll();

            if (cur.x == E.x && cur.y == E.y && cur.dir == E.dir) { // 도착
                answer = cur.time;
                return;
            }

            int nd = cur.dir;
            int nt = cur.time;
            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (cur.dir == 1) { // 세로라면
                    if (nx - 1 < 0 || nx + 1 > N - 1 || ny < 0 || ny > N - 1 || map[nx][ny] == '1'
                            || visited[nd][nx][ny]) {
                        continue;
                    }
                    if (map[nx - 1][ny] == '1' || map[nx + 1][ny] == '1') {
                        continue;
                    }
                    visited[nd][nx][ny] = true;
                    deque.add(new Pos(nx, ny, nd, nt + 1));
                } else { // 가로라면
                    if (nx < 0 || nx > N - 1 || ny - 1 < 0 || ny + 1 > N - 1 || map[nx][ny] == '1'
                            || visited[nd][nx][ny]) {
                        continue;
                    }
                    if (map[nx][ny - 1] == '1' || map[nx][ny + 1] == '1') {
                        continue;
                    }
                    visited[nd][nx][ny] = true;
                    deque.add(new Pos(nx, ny, nd, nt + 1));
                }
            }

            if (cur.dir == 1 && !visited[0][cur.x][cur.y]) { // 세로라면
                boolean isPossible = true;
                for (int i = 0; i < hx.length; i++) {
                    int nx = cur.x + hx[i];
                    int ny = cur.y + hy[i];
                    if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1 || map[nx][ny] == '1') {
                        isPossible = false;
                        break;
                    }
                }

                if (isPossible) {
                    visited[0][cur.x][cur.y] = true;
                    deque.add(new Pos(cur.x, cur.y, 0, cur.time + 1));
                }
            } else if (cur.dir == 0 && !visited[1][cur.x][cur.y]) { // 가로라면
                boolean isPossible = true;
                for (int i = 0; i < hx.length; i++) {
                    int nx = cur.x + hx[i];
                    int ny = cur.y + hy[i];
                    if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1 || map[nx][ny] == '1') {
                        isPossible = false;
                        break;
                    }
                }

                if (isPossible) {
                    visited[1][cur.x][cur.y] = true;
                    deque.add(new Pos(cur.x, cur.y, 1, cur.time + 1));
                }
            }
        }

    }

    static void findCenter() {
        boolean checkB = false;
        boolean checkE = false;
        for (int i = 0; i < N; i++) {
            if (checkB && checkE) {
                break;
            }
            for (int j = 0; j < N; j++) {
                if (!checkB && map[i][j] == 'B') {
                    B = setCenter(i, j);
                    checkB = true;
                }
                if (!checkE && map[i][j] == 'E') {
                    E = setCenter(i, j);
                    checkE = true;
                }
            }
        }
    }

    static Pos setCenter(int x, int y) {
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1 || map[nx][ny] != map[x][y]) {
                continue;
            }
            if (x != nx) { // 세로
                return new Pos(nx, ny, 1, 0);
            } else { // 가로
                return new Pos(nx, ny, 0, 0);
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        findCenter();
        helper();
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }


}