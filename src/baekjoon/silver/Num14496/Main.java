package baekjoon.silver.Num14496;

import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<List<Integer>> list;
    static int a, b;

    static int helper() {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{a, 0});
        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            if (cur[0] == b) {
                return cur[1];
            }
            for (int val : list.get(cur[0])) {
                if (!visited[val]) {
                    visited[val] = true;
                    deque.add(new int[]{val, cur[1] + 1});
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken()) - 1;
        b = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            list.get(x).add(y);
            list.get(y).add(x);
        }
        bw.write(String.valueOf(helper()));

        br.close();
        bw.flush();
        bw.close();
    }
}