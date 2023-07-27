package baekjoon.gold.Num01275;

import java.io.*;
import java.util.*;

public class Main {
    static long[] indexedTree;
    static int offset;

    private static void update(int idx, long value) {
        indexedTree[idx] = value;

        while (idx > 1) {
            idx /= 2;
            indexedTree[idx] = indexedTree[idx * 2] + indexedTree[idx * 2 + 1];
        }
    }

    private static long sum(int l, int r) {
        long sum = 0L;

        while (l <= r) {
            if ((l & 1) == 1)
                sum += indexedTree[l++];
            if ((r & 1) == 0)
                sum += indexedTree[r--];
            l /= 2;
            r /= 2;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        offset = 1;
        while (offset < N) {
            offset *= 2;
        }

        indexedTree = new long[offset * 2 + 2];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            indexedTree[i + offset] = Long.parseLong(st.nextToken());
        }

        for (int i = offset - 1; i >= 1; i--) {
            indexedTree[i] = indexedTree[i * 2] + indexedTree[i * 2 + 1];
        }

        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) + offset - 1;
            int y = Integer.parseInt(st.nextToken()) + offset - 1;

            if (x > y) {
                int temp = x;
                x = y;
                y = temp;
            }
            sb.append(sum(x, y)).append("\n");

            int a = Integer.parseInt(st.nextToken()) + offset - 1;
            long b = Long.parseLong(st.nextToken());
            update(a, b);
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();

    }
}
