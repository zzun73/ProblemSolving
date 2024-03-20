package baekjoon.silver.Num05107;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] root;

    static void init() {
        root = new int[2 * N];
        for (int i = 0; i < 2 * N; i++) {
            root[i] = i;
        }
    }

    static int find(int x) {
        if (root[x] == x) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa < pb) {
            root[pb] = root[pa];
        } else {
            root[pa] = root[pb];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = 1;
        while (true) {
            Map<String, Integer> map = new HashMap<>();
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            init();

            int idx = 0;
            while (N-- > 0) {
                st = new StringTokenizer(br.readLine(), " ");
                String s1 = st.nextToken();
                String s2 = st.nextToken();

                if (!map.containsKey(s1)) {
                    map.put(s1, idx++);
                }
                if (!map.containsKey(s2)) {
                    map.put(s2, idx++);
                }
                union(map.get(s1), map.get(s2));
            }

            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < map.size(); i++) {
                set.add(root[i]);
            }
            sb.append(tc++).append(" ").append(set.size()).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}