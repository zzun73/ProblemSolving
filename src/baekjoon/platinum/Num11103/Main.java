package baekjoon.platinum.Num11103;

import java.io.*;
import java.util.*;

public class Main {
    static long[] indexedTree;
    static int offset;

    private static int addOffset(int value) {
        return value + offset;
    }

    private static long sum(int start, int end) {

        int l = addOffset(start);
        int r = addOffset(end);
        long answer = Long.MAX_VALUE;
        while (l <= r) {
            if ((l & 1) == 1)
                answer = Math.min(answer, indexedTree[l++]);
            if ((r & 1) == 0)
                answer = Math.min(answer, indexedTree[r--]);

            l /= 2;
            r /= 2;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        offset = 1;
        while (offset < N) {
            offset *= 2;
        }
        indexedTree = new long[offset * 2 + 2];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            indexedTree[offset + i] = Long.parseLong(st.nextToken());
        }
        for (int i = offset + N; i < indexedTree.length; i++) {
            indexedTree[i] = Long.MAX_VALUE;
        }

        for (int i = offset - 1; i >= 1; i--) {
            indexedTree[i] = Math.min(indexedTree[i * 2], indexedTree[i * 2 + 1]);
        }

        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = 0;

        for (int i = 0; i < N; i++) {
            sb.append(sum(start, end++)).append("\n");
            if (end >= M) {
                start++;
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();

    }
}
