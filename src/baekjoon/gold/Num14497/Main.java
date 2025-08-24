package baekjoon.gold.Num14497;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, x1, y1, x2, y2;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int helper() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(value -> value[2]));
        pq.add(new int[]{x1, y1, 0});
        visited[x1][y1] = true;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0] == x2 && cur[1] == y2) {
                return cur[2] + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1 || visited[nx][ny]) {
                    continue;
                }

                int w = (map[nx][ny] == '1') ? 1 : 0;
                int nd = cur[2] + w;
                pq.add(new int[]{nx, ny, nd});
                visited[nx][ny] = true;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        x1 = Integer.parseInt(st.nextToken()) - 1;
        y1 = Integer.parseInt(st.nextToken()) - 1;
        x2 = Integer.parseInt(st.nextToken()) - 1;
        y2 = Integer.parseInt(st.nextToken()) - 1;

        map = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        bw.write(String.valueOf(helper()));

        br.close();
        bw.close();
    }
}