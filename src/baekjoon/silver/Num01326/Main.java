package baekjoon.silver.Num01326;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int pos, count;

        Point(int pos, int count) {
            this.pos = pos;
            this.count = count;
        }
    }

    static int N, answer;
    static int[] arr;

    static void helper(int start, int end) {
        Deque<Point> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        deque.add(new Point(start, 0));
        visited[start] = true;

        while (!deque.isEmpty()) {
            Point cur = deque.poll();
            if (cur.pos == end) {
                answer = cur.count;
                return;
            }

            int step = 1;
            while (true) {
                int nextFrontPos = cur.pos + (arr[cur.pos] * step);
                int nextBackPos = cur.pos - (arr[cur.pos] * step);
                int nextCount = cur.count + 1;

                if (!isIn(nextFrontPos) && !isIn(nextBackPos)) {
                    break;
                }

                if (isIn(nextFrontPos) && !visited[nextFrontPos]) {
                    deque.add(new Point(nextFrontPos, nextCount));
                    visited[nextFrontPos] = true;
                }

                if (isIn(nextBackPos) && !visited[nextBackPos]) {
                    deque.add(new Point(nextBackPos, nextCount));
                    visited[nextBackPos] = true;
                }


                step++;
            }
        }
    }

    static boolean isIn(int pos) {
        return pos >= 0 && pos < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        answer = -1;
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;
        helper(a, b);
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}