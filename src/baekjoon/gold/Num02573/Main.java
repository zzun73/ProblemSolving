package baekjoon.gold.Num02573;

import java.io.*;
import java.util.*;

class Node {
    int x, y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M;
    static int[][] board;
    static int[][] height;
    static boolean[][] visited;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static ArrayDeque<Node> deque;

    static boolean helper() {
        while (!deque.isEmpty()) {
            Node node = deque.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1 || board[nx][ny] != 0) {
                    continue;
                }
                height[node.x][node.y]++;
            }
        }

        minusIceHeigh();
        return calcIceSet();
    }

    private static void minusIceHeigh() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] -= height[i][j];
                height[i][j] = 0;
                if (board[i][j] < 0) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private static boolean calcIceSet() {
        visited = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] > 0 && !visited[i][j]) {
                    checkIce(i, j);
                    count++;
                }
            }
        }
        return count >= 2;
    }

    private static void checkIce(int x, int y) {
        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1 || visited[nx][ny] || board[x][y] == 0) {
                continue;
            }
            checkIce(nx, ny);
        }

    }

    private static void findIce() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] > 0) {
                    deque.add(new Node(i, j));
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
        board = new int[N][M];
        height = new int[N][M];
        visited = new boolean[N][M];
        deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true) {
            year++;

            findIce();

            if (deque.isEmpty()) {
                year = 0;
                break;
            }

            if (helper()) break;
        }
        bw.write(String.valueOf(year));

        bw.flush();
        bw.close();
        br.close();
    }
}
