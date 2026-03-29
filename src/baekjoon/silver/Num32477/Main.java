package baekjoon.silver.Num32477;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int[] size;

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) {
            return;
        }

        if (size[pa] < size[pb]) {
            int temp = pa;
            pa = pb;
            pb = temp;
        }

        parent[pb] = pa;
        size[pa] += size[pb];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        size = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        int answer = 1;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, size[find(i)]);
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}