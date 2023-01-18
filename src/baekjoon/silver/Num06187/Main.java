package baekjoon.silver.Num06187;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int C, N;
    static int[] cow;
    static boolean[] visited;
    static int answer;

    public static void helper(int depth, int weight) {
        if (weight <= C) {
            answer = Math.max(weight, answer);
        }

        for (int i = depth; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                helper(i, weight + cow[i]);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        cow = new int[N];
        visited = new boolean[N];
        answer = 0;
        for (int i = 0; i < N; i++) {
            cow[i] = Integer.parseInt(br.readLine());
        }

        helper(0, 0);
        System.out.println(answer);

        br.close();
    }
}
