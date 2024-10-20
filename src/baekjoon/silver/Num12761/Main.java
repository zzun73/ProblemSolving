package baekjoon.silver.Num12761;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Point {
    int pos, depth;

    public Point(int pos, int depth) {
        this.pos = pos;
        this.depth = depth;
    }
}

public class Main {
    private static final int INF = 100_000;
    static int A, B, N, M;
    static int[] dir = new int[6];
    static boolean[] visited = new boolean[INF + 1];

    static int helper() {
        Deque<Point> deque = new ArrayDeque<>();
        deque.add(new Point(N, 0));
        visited[N] = true;

        while (!deque.isEmpty()) {
            Point cur = deque.poll();
            if (cur.pos == M) {
                return cur.depth;
            }

            int nextPos;

            nextPos = cur.pos * A;
            if (!(nextPos < 0 || nextPos > INF || visited[nextPos])) {
                visited[nextPos] = true;
                deque.add(new Point(nextPos, cur.depth + 1));
            }

            nextPos = cur.pos * B;
            if (!(nextPos < 0 || nextPos > INF)) {
                visited[nextPos] = true;
                deque.add(new Point(nextPos, cur.depth + 1));
            }

            for (int i = 0; i < 6; i++) {
                nextPos = cur.pos + dir[i];

                if (nextPos < 0 || nextPos > INF || visited[nextPos]) {
                    continue;
                }

                visited[nextPos] = true;
                deque.add(new Point(nextPos, cur.depth + 1));
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dir[0] = 1;
        dir[1] = -1;
        dir[2] = A;
        dir[3] = -A;
        dir[4] = B;
        dir[5] = -B;


        bw.write(String.valueOf(helper()));

        br.close();
        bw.close();
    }
}