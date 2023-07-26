package baekjoon.gold.Num02042;

import java.io.*;
import java.util.*;

public class Main {
    static long[] indexedTree;
    static int offset;

    private static int addOffset(int value) {
        return value + offset;
    }

    private static void update(int id, long value) {
        int idx = addOffset(id);
        indexedTree[idx] = value;

        while (idx > 1) {
            idx /= 2;
            indexedTree[idx] = indexedTree[idx * 2] + indexedTree[idx * 2 + 1];
        }
    }

    private static long sum(int start, int end) {
        int l = addOffset(start);
        int r = addOffset(end);
        long sum = 0L;

        while (l <= r) {
            if ((l & 1) == 1) {
                sum += indexedTree[l++];
            }
            if ((r & 1) == 0) {
                sum += indexedTree[r--];
            }

            l /= 2;
            r /= 2;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        offset = 1;
        while (offset < N) {
            offset *= 2;
        }
        indexedTree = new long[offset * 2 + 2];

        for (int i = 0; i < N; i++) {
            indexedTree[offset + i] = Long.parseLong(br.readLine());
        }

        for (int i = offset - 1; i >= 1; i--) {
            indexedTree[i] = indexedTree[i * 2] + indexedTree[i * 2 + 1];
        }

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                update(b - 1, c);
            } else {
                sb.append(sum(b - 1, (int) c - 1)).append("\n");
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();

    }
}
