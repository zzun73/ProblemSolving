package baekjoon.silver.Num32344;

import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        void calcPoint(int x, int y) {
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
        }

        long getSize() {
            return (long) (1 + maxX - minX) * (1 + maxY - minY);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Point> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            map.putIfAbsent(a, new Point());
            map.get(a).calcPoint(v, h);
        }

        int answerNumber = Integer.MAX_VALUE;
        long answerSize = 0;
        for (Map.Entry<Integer, Point> entry : map.entrySet()) {
            long size = entry.getValue().getSize();
            if (size > answerSize) {
                answerSize = size;
                answerNumber = entry.getKey();
            } else if (size == answerSize) {
                answerNumber = Math.min(entry.getKey(), answerNumber);
            }
        }
        sb.append(answerNumber).append(" ").append(answerSize);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}