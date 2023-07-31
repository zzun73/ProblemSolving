package baekjoon.gold.Num01717;

import java.io.*;
import java.util.*;

public class Main {
    private static final String Y = "YES";
    private static final String N = "NO";

    static int[] root;
    static int n, m;

    private static void init() {
        for (int i = 0; i <= n; i++) {
            root[i] = i;
        }
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        root[pa] = pb;
    }

    private static int find(int x) {
        if (root[x] == x)
            return x;

        return root[x] = find(root[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        root = new int[n + 1];
        init();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 0) {
                union(a, b);
            } else {
                sb.append(find(a) == find(b) ? Y : N).append("\n");
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
