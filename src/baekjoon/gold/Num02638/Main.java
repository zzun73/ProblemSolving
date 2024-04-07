package baekjoon.gold.Num02638;

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
    static int N, M, cheeseCount, answer;
    static int[][] map;
    static int[][] count;
    static boolean[][] visited;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static Deque<Pos> deque;
    static Set<Pos> set;

    static void search() {
        deque = new ArrayDeque<>();
        count = new int[N][M];
        visited = new boolean[N][M];
        set = new HashSet<>();

        deque.add(new Pos(0, 0));
        visited[0][0] = true;
        while (!deque.isEmpty()) {
            Pos cur = deque.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1 || visited[nx][ny]) {
                    continue;
                }
                if (map[nx][ny] == 1) {
                    count[nx][ny]++;
                } else {
                    visited[nx][ny] = true;
                    deque.add(new Pos(nx, ny));
                }

            }
        }
    }

    static void remove() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (count[i][j] >= 2) {
                    map[i][j] = 0;
                    cheeseCount--;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        answer = cheeseCount = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheeseCount++;
                }
            }
        }

        while (cheeseCount != 0) {
            answer++;
            search();
            remove();
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}