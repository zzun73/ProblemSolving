package baekjoon.gold.Num12837;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int offset;
    static long[] indexedTree;

    public static void update(int idx, int x) {
        indexedTree[idx] += x;

        while (idx > 1) {
            idx /= 2;
            indexedTree[idx] = indexedTree[idx * 2] + indexedTree[idx * 2 + 1];
        }
    }

    public static long query(int l, int r) {
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
        int Q = Integer.parseInt(st.nextToken());

        offset = 1;
        while (offset < N) {
            offset *= 2;
        }
        indexedTree = new long[offset * 2 + 2];

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            switch (command) {
                case 1:
                    update(a + offset - 1, b);
                    break;
                case 2:
                    sb.append(query(a + offset - 1, b + offset - 1)).append("\n");
                    break;
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
