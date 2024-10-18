package swea.d4.Num01249;

import java.io.*;
import java.util.*;

class Pos implements Comparable<Pos> {
    int x, y, cost;

    public Pos(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Pos o) {
        return this.cost - o.cost;
    }
}

public class Solution {

    private static final int INF = 100_000_000;
    static int N;
    static int[][] map;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int[][] distance;
    static PriorityQueue<Pos> pq;

    static void helper() {

        pq.add(new Pos(0, 0, map[0][0]));
        for (int[] row : distance) {
            Arrays.fill(row, INF);
        }
        distance[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Pos cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int cost = cur.cost;

            if (distance[x][y] < cost) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1) {
                    continue;
                }

                int weightSum = cost + map[nx][ny];

                if (weightSum < distance[nx][ny]) {
                    distance[nx][ny] = weightSum;
                    pq.add(new Pos(nx, ny, weightSum));
                }

            }

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            pq = new PriorityQueue<>();
            distance = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j) - '0';
                }
            }
            helper();
            sb.append("#").append(t).append(" ").append(distance[N - 1][N - 1]).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

}