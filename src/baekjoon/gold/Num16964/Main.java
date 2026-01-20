package baekjoon.gold.Num16964;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] edge;
    static List<Integer> path, result;
    static boolean[] visited;

    static void helper(int x) {
        if (visited[x]) {
            return;
        }

        visited[x] = true;
        result.add(x);

        for (int next : edge[x]) {
            if (!visited[next]) {
                helper(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        edge = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            edge[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            edge[A].add(B);
            edge[B].add(A);
        }

        path = new ArrayList<>();
        result = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            path.add(val);
        }

        if (path.get(0) != 1) {
            bw.write("0");
        } else {
            int[] order = new int[N + 1];
            for (int i = 0; i < N; i++) {
                order[path.get(i)] = i;
            }
            for (int i = 1; i <= N; i++) {
                edge[i].sort(Comparator.comparingInt(a -> order[a]));
            }

            helper(1);

            bw.write(result.equals(path) ? "1" : "0");
        }

        br.close();
        bw.close();
    }
}