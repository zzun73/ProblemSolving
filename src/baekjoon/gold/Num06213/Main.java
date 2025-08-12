package baekjoon.gold.Num06213;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int maxValue, minValue;

        public Node(int maxValue, int minValue) {
            this.maxValue = maxValue;
            this.minValue = minValue;
        }

    }

    static int offset, N, Q;
    static Node[] indexedTree;

    static int query(int start, int end) {
        int l = start + offset;
        int r = end + offset;

        Node answer = new Node(0, 1_000_001);

        while (l <= r) {
            if ((l & 1) == 1) {
                answer.maxValue = Math.max(answer.maxValue, indexedTree[l].maxValue);
                answer.minValue = Math.min(answer.minValue, indexedTree[l++].minValue);
            }

            if ((r & 1) == 0) {
                answer.maxValue = Math.max(answer.maxValue, indexedTree[r].maxValue);
                answer.minValue = Math.min(answer.minValue, indexedTree[r--].minValue);
            }

            l /= 2;
            r /= 2;
        }
        return answer.maxValue - answer.minValue;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        for (offset = 1; offset < N; offset *= 2) ;

        indexedTree = new Node[offset * 2 + 2];
        Arrays.fill(indexedTree, new Node(0, 1_000_001));

        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            indexedTree[offset + i] = new Node(val, val);
        }

        for (int i = offset - 1; i >= 1; i--) {
            indexedTree[i] = new Node(Math.max(indexedTree[i * 2].maxValue, indexedTree[i * 2 + 1].maxValue),
                    Math.min(indexedTree[i * 2].minValue, indexedTree[i * 2 + 1].minValue));
        }


        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(query(a - 1, b - 1)).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}