package baekjoon.silver.Num17199;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int count;
    static List<Integer>[] edges;
    static boolean[] visited;

    static void helper(int cur) {
        if (visited[cur]) {
            return;
        }
        visited[cur] = true;
        count++;
        for (int next : edges[cur]) {
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
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            edges[B].add(A);
        }

        int answer = -1;
        for (int i = 1; i <= N; i++) {
            count = 0;
            visited = new boolean[N + 1];
            helper(i);
            if (count == N) {
                answer = i;
                break;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}