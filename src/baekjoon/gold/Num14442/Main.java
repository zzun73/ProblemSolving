package baekjoon.gold.Num14442;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] map;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    static class Person {
        int x, y, distance, smashCount;

        public Person(int x, int y, int distance, int smashCount) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.smashCount = smashCount;
        }
    }

    static int helper() {
        Deque<Person> deque = new ArrayDeque<>();
        deque.add(new Person(0, 0, 1, 0));
        boolean[][][] visited = new boolean[N][M][K + 1];
        visited[0][0][0] = true;

        while (!deque.isEmpty()) {
            Person cur = deque.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.distance;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1) {
                    continue;
                }

                if (!visited[nx][ny][cur.smashCount] && map[nx][ny] == 0) {
                    visited[nx][ny][cur.smashCount] = true;
                    deque.add(new Person(nx, ny, cur.distance + 1, cur.smashCount));
                }

                if (cur.smashCount < K && !visited[nx][ny][cur.smashCount + 1] && map[nx][ny] == 1) {
                    visited[nx][ny][cur.smashCount + 1] = true;
                    deque.add(new Person(nx, ny, cur.distance + 1, cur.smashCount + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bw.write(String.valueOf(helper()));
        br.close();
        bw.close();
    }
}