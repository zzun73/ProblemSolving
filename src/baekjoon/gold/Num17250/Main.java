package baekjoon.gold.Num17250;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] root;
    static int[] weight;

    static long union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa > pb) {
            root[pb] = pa;
            weight[pa] += weight[pb];
            weight[pb] = 0;
            return weight[pa];
        } else if (pa < pb) {
            root[pa] = pb;
            weight[pb] += weight[pa];
            weight[pa] = 0;
            return weight[pb];
        }

        return -1;
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
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        root = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            root[i] = i;
        }

        weight = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int val = Integer.parseInt(br.readLine());
            weight[i] = val;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (find(N) != find(M)) {
                sb.append(union(N, M)).append("\n");
            } else {
                sb.append(Math.max(weight[find(N)], weight[find(M)])).append("\n");
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}