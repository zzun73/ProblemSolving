package baekjoon.gold.Num16933;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

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
        boolean[][][][] visited = new boolean[N][M][K + 1][2];
        visited[0][0][0][0] = true;

        while (!deque.isEmpty()) {
            Person cur = deque.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.distance;
            }

            int nw = (cur.distance + 1) % 2;
            boolean needWait = false;
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    if (!visited[nx][ny][cur.smashCount][nw]) {
                        visited[nx][ny][cur.smashCount][nw] = true;
                        deque.add(new Person(nx, ny, cur.distance + 1, cur.smashCount));
                    }
                } else {
                    if (cur.smashCount < K) {
                        if (!visited[nx][ny][cur.smashCount + 1][nw] && map[nx][ny] == 1 && cur.distance % 2 == 1) {
                            visited[nx][ny][cur.smashCount + 1][nw] = true;
                            deque.add(new Person(nx, ny, cur.distance + 1, cur.smashCount + 1));
                        } else {
                            needWait = true;
                        }
                    }
                }
            }
            if (needWait && !visited[cur.x][cur.y][cur.smashCount][nw]) {
                visited[cur.x][cur.y][cur.smashCount][nw] = true;
                deque.add(new Person(cur.x, cur.y, cur.distance + 1, cur.smashCount));
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
