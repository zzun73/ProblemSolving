package baekjoon.gold.Num05676;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, K, offset;
    static int[] indexedTree;

    static void update(int i, int value) {
        int idx = offset + i;
        indexedTree[idx] = value;

        while (idx > 0) {
            idx /= 2;
            indexedTree[idx] = Integer.compare(indexedTree[idx * 2] * indexedTree[idx * 2 + 1], 0);
        }
    }

    static int query(int start, int end) {
        int left = start + offset;
        int right = end + offset;
        int res = 1;

        while (left <= right) {
            if ((left & 1) == 1) {
                res *= indexedTree[left++];
            }
            if ((right & 1) == 0) {
                res *= indexedTree[right--];
            }
            left /= 2;
            right /= 2;
        }
        return res;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String input;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input, " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            for (offset = 1; offset < N; offset *= 2) ;

            indexedTree = new int[offset * 2 + 2];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                int val = Integer.parseInt(st.nextToken());
                indexedTree[offset + i] = Integer.compare(val, 0);
            }

            for (int i = offset - 1; i >= 1; i--) {
                indexedTree[i] = Integer.compare(indexedTree[i * 2] * indexedTree[i * 2 + 1], 0);
            }

            while (K-- > 0) {
                st = new StringTokenizer(br.readLine(), " ");
                String C = st.nextToken();
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (C.equals("C")) {
                    update(a - 1, b);
                } else if (C.equals("P")) {
                    int result = query(a - 1, b - 1);
                    sb.append(result > 0 ? "+" : result < 0 ? "-" : "0");
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}