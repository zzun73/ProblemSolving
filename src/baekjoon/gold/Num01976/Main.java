package baekjoon.gold.Num01976;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, val, prev, cur;
    static int[] root;
    static boolean isPossible;

    static void init() {
        root = new int[N];

        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa < pb) {
            root[pb] = pa;
        } else {
            root[pa] = pb;
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

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        isPossible = true;
        init();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                val = Integer.parseInt(st.nextToken());
                if (val == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        prev = Integer.parseInt(st.nextToken()) - 1;
        for (int i = 1; i < M; i++) {
            cur = Integer.parseInt(st.nextToken()) - 1;
            if (find(prev) != find(cur)) {
                isPossible = false;
                break;
            }
        }

        bw.write(!isPossible ? "NO" : "YES");
        br.close();
        bw.close();
    }
}
