package baekjoon.gold.Num04485;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int x, y, cost;

    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

public class Main {
    private static final int INF = Integer.MAX_VALUE;
    static int N;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static int[][] arr;
    static int[][] distance;
    static PriorityQueue<Node> pq;

    static void helper() {

        for (int[] row : distance) {
            Arrays.fill(row, INF);
        }
        distance[0][0] = arr[0][0];
        pq.add(new Node(0, 0, distance[0][0]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1) {
                    continue;
                }

                if (distance[nx][ny] > cur.cost + arr[nx][ny]) {
                    distance[nx][ny] = cur.cost + arr[nx][ny];
                    pq.add(new Node(nx, ny, distance[nx][ny]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int t = 1; ; t++) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            pq = new PriorityQueue<>();
            arr = new int[N][N];
            distance = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            helper();

            sb.append("Problem ").append(t).append(": ").append(distance[N - 1][N - 1]).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
