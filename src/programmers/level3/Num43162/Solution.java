package programmers.level3.Num43162;

import java.util.*;

class Solution {
    static int N;
    static int[] root;

    static void init() {
        root = new int[N];
        for (int i = 0; i < N; i++) {
            root[i] = i;
        }
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa >= pb) {
            root[pa] = pb;
        } else {
            root[pb] = pa;
        }
    }

    static int find(int x) {
        if (root[x] == x) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    public int solution(int n, int[][] computers) {
        N = n;
        init();

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int val : root) {
            set.add(find(val));
        }

        return set.size();
    }
}