package baekjoon.silver.Num17086;

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
    static int N, M, answer;
    static int[][] arr;
    static boolean[][] visited;
    static Deque<Node> deque;
    // 8방 탐색
    static int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    static void helper() {
        while (!deque.isEmpty()) {
            Node cur = deque.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                // 배열 범위 밖 or 중복 방문 처리
                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1 || visited[nx][ny]) {
                    continue;
                }

                // 방문 처리 및 안전거리 계산
                visited[nx][ny] = true;
                answer = Math.max(cur.distance + 1, answer);
                deque.add(new Node(nx, ny, cur.distance + 1));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) { // 아기상어인 경우 큐에 삽입
                    deque.add(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        helper();

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}