package baekjoon.gold.Num16562;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] root, groupMinCost, friendCost;
    static int N, M, k;

    static void init() {
        for (int i = 1; i <= N; i++) {
            root[i] = i;
            groupMinCost[i] = friendCost[i];
        }
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa < pb) {
            root[pb] = pa;
            groupMinCost[pa] = Math.min(groupMinCost[pa], groupMinCost[pb]);
        } else if (pa > pb) {
            root[pa] = pb;
            groupMinCost[pb] = Math.min(groupMinCost[pa], groupMinCost[pb]);
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

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        root = new int[N + 1];
        groupMinCost = new int[N + 1];
        friendCost = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            int val = Integer.parseInt(st.nextToken());
            friendCost[i] = val;
        }

        init();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            union(v, w);
        }

        boolean[] visited = new boolean[N + 1];
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int groupRoot = find(i);
            if (!visited[groupRoot]) {
                answer += groupMinCost[groupRoot];
                visited[groupRoot] = true;
            }
        }
        bw.write(String.valueOf(answer <= k ? answer : "Oh no"));

        br.close();
        bw.close();
    }
}