package baekjoon.gold.Num14438;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] indexedTree;
    static int offset;

    private static void update(int i, int v) {
        indexedTree[i] = v;

        while (i > 1) {
            i /= 2;
            indexedTree[i] = Math.min(indexedTree[i * 2], indexedTree[i * 2 + 1]);
        }
    }

    private static int getMin(int l, int r) {
        int answer = Integer.MAX_VALUE;
        while (l <= r) {
            if ((l & 1) == 1) {
                answer = Math.min(indexedTree[l++], answer);
            }
            if ((r & 1) == 0) {
                answer = Math.min(indexedTree[r--], answer);
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

        int N = Integer.parseInt(br.readLine());

        offset = 1;
        while (offset < N) {
            offset *= 2;
        }
        indexedTree = new int[offset * 2 + 2];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            indexedTree[offset + i] = Integer.parseInt(st.nextToken());
        }

        for (int i = offset + N; i < indexedTree.length; i++) {
            indexedTree[i] = Integer.MAX_VALUE;
        }
        for (int i = offset - 1; i >= 1; i--) {
            indexedTree[i] = Math.min(indexedTree[i * 2], indexedTree[i * 2 + 1]);
        }

        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken()) + offset - 1;
            int second = Integer.parseInt(st.nextToken());

            // 업데이트
            if (command == 1) {
                update(first, second);
            }
            //구간 대표값(최소) 출력
            else {
                sb.append(getMin(first, second + offset - 1)).append("\n");
            }

        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
