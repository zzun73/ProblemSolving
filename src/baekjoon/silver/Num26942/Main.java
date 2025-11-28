package baekjoon.silver.Num26942;

import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    static void init(int size) {
        parent = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            parent[i] = i;
        }
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa < pb) {
            parent[pb] = pa;
        } else {
            parent[pa] = pb;
        }

    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String key = br.readLine();
            map.put(key, i);
        }

        init(map.size());
        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            union(map.get(st.nextToken()), map.get(st.nextToken()));
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < parent.length; i++) {
            set.add(find(i));
        }
        bw.write(String.valueOf(set.size()));

        br.close();
        bw.close();
    }
}