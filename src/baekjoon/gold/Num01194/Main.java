package baekjoon.gold.Num01194;

import java.io.*;
import java.util.*;

class Point {
    int x, y, key, distance;

    public Point(int x, int y, int key, int distance) {
        this.x = x;
        this.y = y;
        this.key = key;
        this.distance = distance;
    }
}

public class Main {
    static int N, M, sx, sy, answer;
    static char[][] map;
    static boolean[][][] visited;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static Deque<Point> deque;

    static void helper() {
        deque.add(new Point(sx, sy, 0, 0));

        visited[0][sx][sy] = true;

        while (!deque.isEmpty()) {
            Point cur = deque.poll();
            int x = cur.x;
            int y = cur.y;
            int k = cur.key;
            int d = cur.distance;

            if (map[x][y] == '1') {
                answer = d;
                return;
            }
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 밖 or 이미 방문 or 벽인경우
                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1 || visited[k][nx][ny] || map[nx][ny] == '#') {
                    continue;
                }

                int nk = k;
                if (map[nx][ny] >= 'a' && map[nx][ny] <= 'f') { // 열쇠인 경우 획득
                    nk = k | (1 << map[nx][ny] - 'a');
                } else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'F') { // 문인 경우 열쇠 보유 여부 확인
                    if ((k & (1 << map[nx][ny] - 'A')) <= 0) { // 열쇠 없다면
                        continue;
                    }
                }
                visited[nk][nx][ny] = true;
                deque.add(new Point(nx, ny, nk, d + 1));
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
        answer = -1;
        map = new char[N][M];
        visited = new boolean[64][N][M]; // a,b,c,d,e,f => 2^6
        deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = row[j];
                if (map[i][j] == '0') { // 출발 위치
                    sx = i;
                    sy = j;
                }
            }
        }
        helper();

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}