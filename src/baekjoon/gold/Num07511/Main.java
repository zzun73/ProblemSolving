package baekjoon.gold.Num07511;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, k, m, T;
    static int[] root;

    static void init() {
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa < pb) {
            root[pb] = pa;
        } else if (pa > pb) {
            root[pa] = pb;
        }

    }

    static int find(int x) {
        if (x == root[x]) {
            return x;
        }

        return root[x] = find(root[x]);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            k = Integer.parseInt(br.readLine());
            root = new int[n];

            init();

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                union(u, v);
            }

            sb.append("Scenario ").append(t).append(":").append("\n");
            m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                if (find(u) == find(v)) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}