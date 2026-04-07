package baekjoon.gold.Num09098;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int[] size;

    static void init(int N) {
        parent = new int[N];
        size = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa != pb) {
            parent[pb] = pa;
            size[pa] += size[pb];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            init(N);

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int K = Integer.parseInt(st.nextToken());

                int first = Integer.parseInt(st.nextToken());
                for (int j = 1; j < K; j++) {
                    int next = Integer.parseInt(st.nextToken());
                    union(first, next);
                }
            }

            sb.append(size[find(0)]).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}