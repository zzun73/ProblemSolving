package baekjoon.silver.Num27971;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, A, B;
    static int[][] arr;
    static boolean[] blocked, visited;

    static class Point {
        int value, count;

        public Point(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    static int helper() {
        Deque<Point> deque = new ArrayDeque<>();
        deque.add(new Point(0, 0));
        visited[0] = true;

        while (!deque.isEmpty()) {
            Point cur = deque.poll();

            if (cur.value == N) {
                return cur.count;
            }

            for (int step : new int[]{A, B}) {
                int next = cur.value + step;
                if (next <= N && !blocked[next] && !visited[next]) {
                    visited[next] = true;
                    deque.add(new Point(next, cur.count + 1));
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
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        arr = new int[M][2];
        blocked = new boolean[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            while (L <= R) {
                blocked[L++] = true;
            }
        }

        bw.write(String.valueOf(helper()));

        br.close();
        bw.close();
    }
}