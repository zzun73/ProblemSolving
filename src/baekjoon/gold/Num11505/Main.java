package baekjoon.gold.Num11505;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final int MOD = 1_000_000_007;
    static int offset;
    static long[] indexedTree;

    public static void update(int x, int v) {
        indexedTree[x] = v;

        while (x > 0) {
            x /= 2;
            indexedTree[x] = (indexedTree[x * 2] * indexedTree[x * 2 + 1]) % MOD;
        }
    }

    public static long query(int l, int r) {
        long answer = 1L;
        while (l <= r) {
            if ((l & 1) == 1) {
                answer = (answer * indexedTree[l++]) % MOD;
            }
            if ((r & 1) == 0) {
                answer = (answer * indexedTree[r--]) % MOD;
            }
            l /= 2;
            r /= 2;
        }
        return answer;
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


        for (int i = offset; i < N + offset; i++) {
            indexedTree[i] = Long.parseLong(br.readLine());
        }

        for (int i = offset - 1; i >= 1; i--) {
            indexedTree[i] = (indexedTree[i * 2] * indexedTree[i * 2 + 1]) % MOD;
        }

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                update(b - 1 + offset, c);
            } else {
                sb.append(query(b - 1 + offset, c - 1 + offset)).append("\n");
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
