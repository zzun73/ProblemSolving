package baekjoon.silver.Num24164;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] root;

    static void init() {
        for (int i = 1; i <= n; i++) {
            root[i] = i;
        }
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa > pb) {
            root[pa] = pb;
        } else if (pa < pb) {
            root[pb] = pa;
        }
    }

    static int find(int x) {
        if (root[x] == x) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        root = new int[n + 1];
        init();

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        int parent = 0;
        for (int i = 1; i <= n; i++) {
            if (find(i) == i) {
                parent++;
            }
        }
        bw.write(String.valueOf(parent - 1));

        br.close();
        bw.close();
    }
}