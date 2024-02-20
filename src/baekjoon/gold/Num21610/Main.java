package baekjoon.gold.Num21610;

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
    static int N, M, d, s;
    static int[][] map;
    static boolean[][] visited; // 구름 생겼던 곳 체크
    static Deque<Pos> deque;
    static int[] dx = new int[]{0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};

    static void moveCloudAndRain() {
        for (Pos cur : deque) {
            //구름 이동
            cur.x = (N + cur.x + dx[d] * (s % N)) % N;
            cur.y = (N + cur.y + dy[d] * (s % N)) % N;
//            cur.x = Math.abs(cur.x + dx[d] * s) % N;
//            cur.y = Math.abs(cur.y + dy[d] * s) % N;

            //비 내림
            map[cur.x][cur.y] += 1;
        }
    }

    static void waterCopyBugMagic() {
        while (!deque.isEmpty()) {
            Pos cur = deque.poll();
            int count = 0;

            for (int i = 1; i < dx.length; i += 2) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1 || map[nx][ny] == 0) {
                    continue;
                }
                count++;
            }

            // 대각선 거리 1칸 물이 있는 바구니 수 만큼 물 증가
            map[cur.x][cur.y] += count;

            // 구름 발생한 곳 체크
            visited[cur.x][cur.y] = true;
        }
    }

    static void makeCloud() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 물의 양 2이상이면서 구름이 사라진 칸이 아닌 경우
                if (map[i][j] >= 2 && !visited[i][j]) {
                    deque.add(new Pos(i, j));
                    map[i][j] -= 2;
                }
            }
        }
    }

    static int calcSumWater() {
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res += map[i][j];
            }
        }
        return res;
    }

    private static void initCloud() {
        deque.add(new Pos(N - 2, 0));
        deque.add(new Pos(N - 2, 1));
        deque.add(new Pos(N - 1, 0));
        deque.add(new Pos(N - 1, 1));

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        deque = new ArrayDeque<>();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 구름 생성
        initCloud();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            d = Integer.parseInt(st.nextToken()) - 1; // 방향
            s = Integer.parseInt(st.nextToken()); // 거리
            visited = new boolean[N][N];
            // 구름 이동 및 비내림
            moveCloudAndRain();

            // 물복사버그마법
            waterCopyBugMagic();

            // 구름 생성
            makeCloud();
        }
        bw.write(String.valueOf(calcSumWater()));

        br.close();
        bw.close();
    }
}