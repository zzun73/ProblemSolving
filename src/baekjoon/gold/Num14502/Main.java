package baekjoon.gold.Num14502;

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

    private static final int MAX_WALL = 3;
    static int N, M, count, answer;
    static int[][] originalMap, gameMap;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static boolean[][] visited;
    static Deque<Pos> virus, deque;

    static void helper(int count) {

        if (count == MAX_WALL) { // 벽을 다 세운 경우
            init(); // 게임 진행용 복사
            transition(); // 바이러스 전이
            calcSafeArea(); // 안전영역 계산
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (originalMap[i][j] == 0) { // 빈칸이며 아직 벽을 세우지 않은 경우
                    originalMap[i][j] = 1;
                    helper(count + 1);
                    originalMap[i][j] = 0;
                }
            }
        }
    }

    static void transition() {
        while (!virus.isEmpty()) {
            Pos cur = virus.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                // 범위 밖 or 이미 방문 or 벽인경우
                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1 || visited[nx][ny] || gameMap[nx][ny] == 1) {
                    continue;
                }
                visited[nx][ny] = true;
                gameMap[nx][ny] = 2;
                virus.add(new Pos(nx, ny));
            }
        }
    }

    static void init() {
        for (int i = 0; i < N; i++) {
            gameMap[i] = originalMap[i].clone();
        }

        virus = new ArrayDeque<>(deque);
        visited = new boolean[N][M];
    }

    static void calcSafeArea() {
        count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (gameMap[i][j] == 0) {
                    count++;
                }
            }
        }
        answer = Math.max(answer, count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        originalMap = new int[N][M];
        gameMap = new int[N][M];
        visited = new boolean[N][M];
        deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                originalMap[i][j] = Integer.parseInt(st.nextToken());

                if (originalMap[i][j] == 2) {
                    deque.add(new Pos(i, j));
                }
            }
        }
        helper(0);

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }

}
