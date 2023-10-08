package baekjoon.gold.Num17352;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[] root;

    public static int find(int x) {
        if (root[x] == x) {
            return x;
        } else {
            return find(root[x]);
        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a < b) {
                root[b] = a;
            } else {
                root[a] = b;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        root = new int[N + 1];
        for (int i = 1; i < root.length; i++) {
            root[i] = i;
        }

        for (int i = 0; i < N - 2; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        for (int i = 1; i < N; i++) {
            if (find(i) != find(i + 1)) {
                sb.append(i).append(" ").append(i + 1);
                break;
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}