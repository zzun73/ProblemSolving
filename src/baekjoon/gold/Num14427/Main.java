package baekjoon.gold.Num14427;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, offset, command, a, b;
    static int[] indexedTree;
    static int[] arr;

    static void update(int id, int target) {
        id += offset - 1;
        arr[indexedTree[id]] = target;

        while (id > 1) {
            id /= 2;
            compare(id);
        }
    }

    static void compare(int idx) {
        if (arr[indexedTree[idx * 2]] < arr[indexedTree[idx * 2 + 1]]) {
            indexedTree[idx] = indexedTree[idx * 2];
        } else if (arr[indexedTree[idx * 2]] > arr[indexedTree[idx * 2 + 1]]) {
            indexedTree[idx] = indexedTree[idx * 2 + 1];
        } else {
            indexedTree[idx] = Math.min(indexedTree[idx * 2], indexedTree[idx * 2 + 1]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        offset = 1;
        while (offset <= N) {
            offset *= 2;
        }

        indexedTree = new int[offset * 2 + 2];
        arr = new int[N + 1];
        arr[0] = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i + 1] = Integer.parseInt(st.nextToken());
            indexedTree[i + offset] = i + 1;
        }

        for (int i = offset + N; i < indexedTree.length; i++) {
            indexedTree[i] = 0;
        }

        for (int i = offset - 1; i >= 1; i--) {
            compare(i);
        }

        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            command = Integer.parseInt(st.nextToken());

            if (command == 1) {
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                update(a, b);
            } else {
                sb.append(indexedTree[1]).append("\n");
            }

        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
