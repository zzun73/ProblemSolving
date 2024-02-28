package baekjoon.gold.Num01600;

import java.io.*;
import java.util.*;

class Monkey {
    int x, y, distance, horseCount;

    public Monkey(int x, int y, int distance, int horseCount) {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.horseCount = horseCount;
    }
}

public class Main {
    static int K, W, H, answer;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int[] hx = new int[]{-2, -2, -1, -1, 2, 2, 1, 1};
    static int[] hy = new int[]{-1, 1, -2, 2, -1, 1, -2, 2};
    static Deque<Monkey> deque;

    static void helper() {
        deque.add(new Monkey(0, 0, 0, 0));
        visited[0][0][K] = true;

        while (!deque.isEmpty()) {
            Monkey cur = deque.poll();

            if (cur.x == H - 1 && cur.y == W - 1) {
                answer = Integer.min(answer, cur.distance);
                return;
            }

            if (cur.horseCount < K) {
                for (int i = 0; i < hx.length; i++) {
                    int nx = cur.x + hx[i];
                    int ny = cur.y + hy[i];

                    // 범위 밖 or 이미 방문 or 장애물
                    if (nx < 0 || nx > H - 1 || ny < 0 || ny > W - 1 || visited[nx][ny][cur.horseCount + 1]
                            || map[nx][ny] == 1) {
                        continue;
                    }
                    visited[nx][ny][cur.horseCount + 1] = true;
                    deque.add(new Monkey(nx, ny, cur.distance + 1, cur.horseCount + 1));
                }
            }
            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                // 범위 밖 or 이미 방문 or 장애물
                if (nx < 0 || nx > H - 1 || ny < 0 || ny > W - 1 || visited[nx][ny][cur.horseCount]
                        || map[nx][ny] == 1) {
                    continue;
                }
                visited[nx][ny][cur.horseCount] = true;
                deque.add(new Monkey(nx, ny, cur.distance + 1, cur.horseCount));
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        deque = new ArrayDeque<>();
        K = Integer.parseInt(br.readLine()); // 말처럼 이동할 수 있는 횟수

        st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        map = new int[H][W];
        visited = new boolean[H][W][K + 1];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        helper();
        bw.write(String.valueOf(answer == Integer.MAX_VALUE ? -1 : answer));
        br.close();
        bw.close();
    }

}
