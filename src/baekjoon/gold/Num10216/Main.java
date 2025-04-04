package baekjoon.gold.Num10216;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] parent;
    static Circle[] circles;

    static class Circle {
        int x, y, r;

        public Circle(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

    static void init() {
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (parent[pa] <= parent[pb]) {
            parent[pb] = pa;
        } else {
            parent[pa] = pb;
        }
    }

    static boolean isSameZone(int i, int j) {
        int dx = circles[i].x - circles[j].x;
        int dy = circles[i].y - circles[j].y;
        int distance = dx * dx + dy * dy;
        int range = circles[i].r + circles[j].r;
        return distance <= (range * range);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            init();
            circles = new Circle[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());
                circles[i] = new Circle(X, Y, R);
            }

            int answer = N;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (isSameZone(i, j)) {
                        if (find(i) != find(j)) {
                            union(i, j);
                            answer--;
                        }
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}