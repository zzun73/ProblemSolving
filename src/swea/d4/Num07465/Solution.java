package swea.d4.Num07465;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static int[] parent;

    static void init() {
        for (int i = 0; i < parent.length; i++) {
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
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            parent = new int[N];
            init();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                union(a, b);
            }

            int answer = 0;
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == i) {
                    answer++;
                }
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}