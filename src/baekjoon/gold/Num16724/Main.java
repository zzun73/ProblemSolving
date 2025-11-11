package baekjoon.gold.Num16724;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] root;
    static int N, M;

    static void init() {
        root = new int[N * M];
        for (int i = 0; i < N * M; i++) {
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
            root[pb] = pa;
        } else {
            root[pa] = pb;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        init();
        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                char ch = row[j];
                int curIdx = i * M + j;
                int ni = i;
                int nj = j;
                if (ch == 'U') {
                    ni = i - 1;
                } else if (ch == 'D') {
                    ni = i + 1;
                } else if (ch == 'L') {
                    nj = j - 1;
                } else if (ch == 'R') {
                    nj = j + 1;
                }
                int targetIdx = ni * M + nj;
                union(curIdx, targetIdx);
            }
        }

        int answer = 0;
        for (int i = 0; i < N * M; i++) {
            if (find(i) == i) {
                answer++;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}