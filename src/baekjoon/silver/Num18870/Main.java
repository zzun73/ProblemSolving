package baekjoon.silver.Num18870;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Point implements Comparable<Point> {
        int index, val;

        public Point(int index, int val) {
            this.index = index;
            this.val = val;
        }

        @Override
        public int compareTo(Point o) {
            return this.val - o.val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            points.add(new Point(i, val));
        }
        Collections.sort(points);

        int[] answer = new int[N];

        answer[points.get(0).index] = 0;
        for (int i = 1; i < N; i++) {
            if (points.get(i).val == points.get(i - 1).val) {
                answer[points.get(i).index] = answer[points.get(i - 1).index];
            } else {
                answer[points.get(i).index] = answer[points.get(i - 1).index] + 1;
            }
        }

        for (int ans : answer) {
            sb.append(ans).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}