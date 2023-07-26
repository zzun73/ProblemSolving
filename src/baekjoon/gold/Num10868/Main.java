package baekjoon.gold.Num10868;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] indexedTree;
    static int offset;

    private static int findMinValue(int start, int end) {
        int l = start + offset;
        int r = end + offset;
        int min = Integer.MAX_VALUE;

        while (l <= r) {

            if ((l & 1) == 1) {
                min = Math.min(min, indexedTree[l++]);
            }
            if ((r & 1) == 0) {
                min = Math.min(min, indexedTree[r--]);
            }

            l /= 2;
            r /= 2;
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        offset = 1;
        while (offset < N) {
            offset *= 2;
        }
        indexedTree = new int[offset * 2 + 2];

        for (int i = 0; i < N; i++) {
            indexedTree[offset + i] = Integer.parseInt(br.readLine());
        }

        for (int i = offset - 1; i >= 1; i--) {
            indexedTree[i] = Math.min(indexedTree[i * 2], indexedTree[i * 2 + 1]);
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            sb.append(findMinValue(a, b)).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
