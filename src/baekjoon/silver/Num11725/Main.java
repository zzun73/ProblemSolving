package baekjoon.silver.Num11725;

import java.io.*;
import java.util.*;


public class Main {
    static int N, A, B;
    static List<Integer>[] lists;
    static int[] answer;
    static boolean[] visited;

    static void helper(int cur) {
        visited[cur] = true;
        for (Integer next : lists[cur]) {
            if (!visited[next]) {
                answer[next] = cur;
                helper(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        lists = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        answer = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            lists[A].add(B);
            lists[B].add(A);
        }

        helper(1);

        for (int i = 2; i <= N; i++) {
            sb.append(answer[i]).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}