package baekjoon.silver.Num24484;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> list;
    static boolean[] visited;
    static long t;
    static long answer;

    public static void helper(int start, int depth) {
        visited[start] = true;
        answer += depth * t++;
        for (int val : list.get(start)) {
            if (!visited[val]) {
                helper(val, depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        visited = new boolean[N + 1];
        t = 1;
        answer = 0;
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(list.get(i));
            Collections.reverse(list.get(i));
        }

        helper(R, 0);

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}