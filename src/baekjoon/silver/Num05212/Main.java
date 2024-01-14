package baekjoon.silver.Num05212;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static Deque<Node> deque = new ArrayDeque<>();
    static int R, C;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int minX = Integer.MAX_VALUE;
    static int minY = Integer.MAX_VALUE;
    static int maxX = Integer.MIN_VALUE;
    static int maxY = Integer.MIN_VALUE;

    static void helper() {
        while (!deque.isEmpty()) {
            Node node = deque.poll();
            int count = 0;
            for (int i = 0; i < dx.length; i++) {
                int nx = dx[i] + node.x;
                int ny = dy[i] + node.y;

                if (nx < 0 || nx > R - 1 || ny < 0 || ny > C - 1) {
                    continue;
                }
                if (board[nx][ny] == 'X') {
                    count++;
                }
            }
            if (count >= 2) {
                visited[node.x][node.y] = true;
                minX = Math.min(minX, node.x);
                maxX = Math.max(maxX, node.x);
                minY = Math.min(minY, node.y);
                maxY = Math.max(maxY, node.y);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        visited = new boolean[R][C];
        deque = new ArrayDeque<>();
        for (int i = 0; i < R; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                board[i][j] = row[j];
                if (row[j] == 'X') {
                    deque.add(new Node(i, j));
                }
            }
        }
        helper();

        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                if (visited[i][j]) {
                    sb.append(board[i][j]);
                } else {
                    sb.append(".");
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}