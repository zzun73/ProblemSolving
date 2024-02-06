package baekjoon.gold.Num02589;

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
    static int N, M, maxDistance;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static Deque<Node> deque;

    static void helper() {
        while (!deque.isEmpty()) {
            Node cur = deque.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;
                // 배열 범위 초과 or 이미 방문 or 바다인 경우 스킵
                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1 || visited[nx][ny] || map[nx][ny] == 'W') {
                    continue;
                }

                // 1칸 이동할 때 마다 거리 갱신 및 방문 표시
                visited[nx][ny] = true;
                deque.add(new Node(nx, ny, cur.distance + 1));
                maxDistance = Math.max(maxDistance, cur.distance + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        deque = new ArrayDeque<>();
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < M; j++) {
                visited = new boolean[N][M];

                if (map[i][j] == 'L') { // 육지인 경우 탐색진행
                    deque.add(new Node(i, j, 0));
                    visited[i][j] = true;
                    helper();
                }
            }
        }

        bw.write(String.valueOf(maxDistance));

        br.close();
        bw.close();
    }
}