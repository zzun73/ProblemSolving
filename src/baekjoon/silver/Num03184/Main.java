package baekjoon.silver.Num03184;

import java.io.*;
import java.util.*;

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

public class Main {
    static int R, C;
    static int sheepCount, wolfCount, totalSheep, totalWolf;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static Deque<Node> deque;

    static void helper() {
        sheepCount = 0;
        wolfCount = 1; // 초기 늑대 1마리

        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                // 배열 범위 밖 or 이미 방문 or 울타리일 경우
                if (nx < 0 || nx > R - 1 || ny < 0 || ny > C - 1 || visited[nx][ny] || board[nx][ny] == '#') {
                    continue;
                }
                if (board[nx][ny] == 'v') {
                    wolfCount++;
                } else if (board[nx][ny] == 'o') {
                    sheepCount++;
                }
                visited[nx][ny] = true;
                deque.add(new Node(nx, ny));
            }
        }

        if (sheepCount > wolfCount) {
            totalWolf -= wolfCount;
        } else {
            totalSheep -= sheepCount;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        deque = new ArrayDeque<>();
        board = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                board[i][j] = row[j];
                if (row[j] == 'o') {
                    totalSheep++;
                } else if (row[j] == 'v') {
                    totalWolf++;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'v' && !visited[i][j]) { // 아직 탐색하지 않은 늑대인 경우
                    deque.add(new Node(i, j));
                    visited[i][j] = true;
                    helper();

                }
            }
        }
        sb.append(totalSheep).append(" ").append(totalWolf);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
