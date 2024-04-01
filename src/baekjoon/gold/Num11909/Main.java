package baekjoon.gold.Num11909;

import java.io.*;
import java.util.*;

public class Main {
    private static final int INF = Integer.MAX_VALUE;
    static int N;
    static int[][] map;
    static int[][] distance;
    static int[] dx = new int[]{1, 0};
    static int[] dy = new int[]{0, 1};
    static PriorityQueue<Edge> pq;

    static class Edge implements Comparable<Edge> {
        int x, y, cost;

        public Edge(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static void helper() {
        for (int[] row : distance) {
            Arrays.fill(row, INF);
        }

        pq.add(new Edge(1, 1, 0));
        distance[1][1] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            if (distance[x][y] < cur.cost) {
                continue;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || nx > N || ny < 1 || ny > N) {
                    continue;
                }
                int weightSum = map[x][y] - map[nx][ny];
                if (weightSum > 0) {
                    weightSum = 0;
                } else {
                    weightSum = map[nx][ny] + 1 - map[x][y];
                }

                if (distance[nx][ny] > weightSum + cur.cost) {
                    distance[nx][ny] = weightSum + cur.cost;
                    pq.add(new Edge(nx, ny, distance[nx][ny]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        distance = new int[N + 1][N + 1];
        pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        helper();

        bw.write(String.valueOf(distance[N][N]));
        br.close();
        bw.close();
    }
}