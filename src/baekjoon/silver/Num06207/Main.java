package baekjoon.silver.Num06207;

import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] edges;
    static boolean[] visited;
    static int[] count;

    static void helper(int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        visited[start] = true;
        deque.add(start);

        while (!deque.isEmpty()) {
            int cur = deque.poll();
            count[cur]++;

            for (int next : edges[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    deque.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] starts = new int[K];
        for (int i = 0; i < K; i++) {
            int val = Integer.parseInt(br.readLine().trim());
            starts[i] = val;
        }

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            edges[A].add(B);
        }

        int answer = 0;
        count = new int[N + 1];
        for (int val : starts) {
            visited = new boolean[N + 1];
            helper(val);
        }

        for (int i = 1; i <= N; i++) {
            if (count[i] == K) {
                answer++;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
