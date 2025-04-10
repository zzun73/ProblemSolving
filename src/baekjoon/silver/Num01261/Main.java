package baekjoon.silver.Num01261;

import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] map;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    static class Node implements Comparable<Node> {
        int x, y, crush;

        public Node(int x, int y, int crush) {
            this.x = x;
            this.y = y;
            this.crush = crush;
        }

        @Override
        public int compareTo(Node o) {
            return this.crush - o.crush;
        }
    }

    static int helper() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][M];

        pq.add(new Node(0, 0, 0));
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.crush;
            }

            for (int d = 0; d < dx.length; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                if (map[nx][ny] == 1) {
                    pq.add(new Node(nx, ny, cur.crush + 1));
                } else {
                    pq.add(new Node(nx, ny, cur.crush));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = row[j] - '0';
            }
        }

        bw.write(String.valueOf(helper()));

        br.close();
        bw.close();
    }
}
