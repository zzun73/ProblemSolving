package baekjoon.gold.Num02636;

import java.io.*;
import java.util.*;

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M, totalCheeseCount, prevCheeseCount, time;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static Deque<Pos> deque;

    static void helper() {
        visited = new boolean[N][M];
        deque = new ArrayDeque<>();
        deque.add(new Pos(0, 0));
        visited[0][0] = true;

        while (!deque.isEmpty()) {
            Pos cur = deque.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1 || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                if (map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    totalCheeseCount--;
                } else {
                    deque.add(new Pos(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        deque = new ArrayDeque<>();
        totalCheeseCount = time = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    totalCheeseCount++;
                }
            }
        }

        prevCheeseCount = totalCheeseCount;
        while (totalCheeseCount != 0) {
            prevCheeseCount = totalCheeseCount;
            time++;
            helper();
        }
        sb.append(time).append("\n").append(prevCheeseCount);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

}
