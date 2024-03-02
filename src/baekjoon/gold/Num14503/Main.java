package baekjoon.gold.Num14503;

import java.io.*;
import java.util.*;

class Robot {
    int x, y, d;

    public Robot(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

public class Main {
    private static final int DIRECTION_SIZE = 4;
    static int N, M, r, c, d;
    static int[][] board;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int answer;
    static Deque<Robot> deque;

    static void helper(int rx, int ry, int rd) {
        deque.add(new Robot(rx, ry, rd));

        while (!deque.isEmpty()) {
            Robot robot = deque.poll();
            boolean isMove = false;

            if (board[robot.x][robot.y] == 0) {
                board[robot.x][robot.y] = -1;
                answer++;
            }

            for (int i = 0; i < dx.length; i++) {
                int nd = (robot.d + 3 - i) % DIRECTION_SIZE;
                int nx = robot.x + dx[nd];
                int ny = robot.y + dy[nd];

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1 || board[nx][ny] != 0) { // 범위 밖 인경우
                    continue;
                }

                deque.add(new Robot(nx, ny, nd));
                isMove = true;
                break;
            }

            if (!isMove) {
                int nd = (robot.d + 2) % DIRECTION_SIZE;
                int nx = robot.x + dx[nd];
                int ny = robot.y + dy[nd];

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1 || board[nx][ny] == 1) {
                    return;
                }
                deque.add(new Robot(nx, ny, robot.d));
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
        board = new int[N][M];

        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        answer = 0;
        deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        helper(r, c, d);

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
