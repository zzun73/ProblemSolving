package baekjoon.silver.Num31575;

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
    static int N, M;
    static int[][] map;
    static int[] dx = new int[]{0, 1};
    static int[] dy = new int[]{1, 0};

    static boolean helper() {
        Deque<Pos> deque = new ArrayDeque<>();

        deque.add(new Pos(0, 0));
        while (!deque.isEmpty()) {
            Pos cur = deque.poll();
            if (cur.x == M - 1 && cur.y == N - 1) {
                return true;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx > M - 1 || ny < 0 || ny > N - 1 || map[nx][ny] != 1) {
                    continue;
                }
                map[nx][ny] = 9;
                deque.add(new Pos(nx, ny));
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bw.write(helper() ? "Yes" : "No");

        br.close();
        bw.close();
    }
}