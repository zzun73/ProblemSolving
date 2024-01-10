package baekjoon.gold.Num02146;

import java.io.*;
import java.util.*;

class Node {
    int x, y, value;

    Node(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;

    }
}

public class Main {
    static int N, number;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    static void markNumber(int x, int y) {

        if (x < 0 || x > N - 1 || y < 0 || y > N - 1 || visited[x][y] || arr[x][y] != 1) {
            return;
        }
        arr[x][y] = number;
        visited[x][y] = true;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            markNumber(nx, ny);
        }
    }

    static int helper(int x, int y, int label) {
        visited = new boolean[N][N];
        int res = Integer.MAX_VALUE;
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(x, y, 0));
        visited[x][y] = true;

        while (!deque.isEmpty()) {
            Node node = deque.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1 || visited[nx][ny] || arr[nx][ny] == label) {
                    continue;
                }
                if (arr[nx][ny] != 0 && arr[nx][ny] != label) {
                    res = Math.min(node.value, res);
                }

                visited[nx][ny] = true;
                deque.add(new Node(nx, ny, node.value + 1));
            }
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        number = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    markNumber(i, j);
                    number++;
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] > 1) {
                    answer = Math.min(helper(i, j, arr[i][j]), answer);
                }
            }
        }
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}
