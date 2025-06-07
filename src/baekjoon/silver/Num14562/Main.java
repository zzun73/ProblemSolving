package baekjoon.silver.Num14562;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int s, t, count;

        Point(int s, int t, int count) {
            this.s = s;
            this.t = t;
            this.count = count;
        }
    }

    static int helper(int S, int T) {

        Deque<Point> deque = new ArrayDeque<>();
        deque.add(new Point(S, T, 0));

        while (!deque.isEmpty()) {
            Point cur = deque.poll();
            if (cur.s == cur.t) {
                return cur.count;
            }

            if (cur.s > cur.t) {
                continue;
            }
            deque.add(new Point(cur.s + 1, cur.t, cur.count + 1));
            deque.add(new Point(cur.s * 2, cur.t + 3, cur.count + 1));
        }
        return -1;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int C = Integer.parseInt(br.readLine());
        while (C-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            sb.append(helper(S, T)).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}