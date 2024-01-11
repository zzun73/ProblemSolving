package baekjoon.silver.Num01303;

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
    static int M, N;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    static int helper(int x, int y) {
        ArrayDeque<Node> deque = new ArrayDeque<>();
        visited[x][y] = true;
        deque.add(new Node(x, y));
        int res = 1;
        while (!deque.isEmpty()) {
            Node node = deque.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1 || visited[nx][ny] || board[x][y] != board[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                deque.add(new Node(nx, ny));
                res++;
            }
        }

        return res * res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = row[j];
            }
        }

        int[] answer = new int[2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    if (board[i][j] == 'W') {
                        answer[0] += helper(i, j);
                    } else {
                        answer[1] += helper(i, j);
                    }
                }
            }
        }

        for (int val : answer) {
            sb.append(val).append(" ");
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
