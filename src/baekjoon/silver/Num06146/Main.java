package baekjoon.silver.Num06146;

import java.io.*;
import java.util.*;

class Node {
    int x, y, distance;

    public Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}

public class Main {
    private static final int SIZE = 500;
    static int X, Y, N;
    static int[][] arr;
    static boolean[][] visited;
    static Deque<Node> deque;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    static int helper() {
        while (!deque.isEmpty()) {
            Node cur = deque.poll();
            if (cur.x == X && cur.y == Y) {
                return cur.distance;
            }
            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                // 배열 범위 밖 or 이미 방문 or 웅덩이일 경우 skip
                if (nx < 0 || nx > arr.length - 1 || ny < 0 || ny > arr.length - 1 || visited[nx][ny] || arr[nx][ny] == -1) {
                    continue;
                }

                // 방문 표시 및 이동 거리 누적
                visited[nx][ny] = true;
                deque.add(new Node(nx, ny, cur.distance + 1));
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        X = Integer.parseInt(st.nextToken()) + SIZE;
        Y = Integer.parseInt(st.nextToken()) + SIZE;
        N = Integer.parseInt(st.nextToken());

        arr = new int[SIZE * 2 + 1][SIZE * 2 + 1];
        visited = new boolean[arr.length][arr.length];
        deque = new ArrayDeque<>();

        // 0,0이 출발 지점
        deque.add(new Node(SIZE, SIZE, 0));
        visited[SIZE][SIZE] = true;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken()) + SIZE;
            int B = Integer.parseInt(st.nextToken()) + SIZE;
            arr[A][B] = -1; // 웅덩이는 -1로 표시
        }
        bw.write(String.valueOf(helper()));

        br.close();
        bw.close();
    }
}