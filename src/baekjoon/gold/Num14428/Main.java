package baekjoon.gold.Num14428;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int index, value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        static Node min(Node a, Node b) {
            if (a.value < b.value) {
                return a;
            }
            if (a.value > b.value) {
                return b;
            }
            return a.index < b.index ? a : b;
        }
    }

    static int offset;
    static Node[] indexedTree;

    static void update(int id, int value) {
        int index = id + offset - 1;
        indexedTree[index] = new Node(id, value);

        while (index > 0) {
            index /= 2;
            indexedTree[index] = Node.min(indexedTree[index * 2], indexedTree[index * 2 + 1]);
        }
    }

    static Node query(int start, int end) {
        int left = start + offset - 1;
        int right = end + offset - 1;
        Node res = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);

        while (left <= right) {
            if ((left & 1) == 1) {
                res = Node.min(res, indexedTree[left++]);
            }
            if ((right & 1) == 0) {
                res = Node.min(res, indexedTree[right--]);
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

        int N = Integer.parseInt(br.readLine());

        for (offset = 1; offset < N; offset *= 2) ;
        indexedTree = new Node[offset * 2 + 2];

        for (int i = 0; i < indexedTree.length; i++) {
            indexedTree[i] = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }


        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            indexedTree[offset + i] = new Node(i + 1, val);
        }

        for (int i = offset - 1; i >= 1; i--) {
            indexedTree[i] = Node.min(indexedTree[i * 2], indexedTree[i * 2 + 1]);
        }

        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 1) {
                update(a, b);
            } else if (command == 2) {
                sb.append(query(a, b).index).append("\n");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}