package baekjoon.gold.Num04195;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] root, rank;

    static void init() {
        rank = new int[2 * N];
        root = new int[2 * N];
        for (int i = 0; i < 2 * N; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    static int union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if (fa != fb) {
            root[fb] = fa;
            rank[fa] += rank[fb];
        }
        return rank[fa];
    }

    static int find(int id) {
        if (root[id] == id) {
            return id;
        }
        return root[id] = find(root[id]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            init();
            int keyNumber = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                String s1 = st.nextToken();
                String s2 = st.nextToken();

                if (!map.containsKey(s1)) {
                    map.put(s1, keyNumber++);
                }
                if (!map.containsKey(s2)) {
                    map.put(s2, keyNumber++);
                }

                sb.append(union(map.get(s1), map.get(s2))).append("\n");
            }
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}