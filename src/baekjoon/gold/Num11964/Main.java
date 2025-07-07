package baekjoon.gold.Num11964;

import java.io.*;
import java.util.*;

public class Main {
    static int T, A, B, answer;
    static boolean[] visited;

    static void helper() {
        Deque<int[]> deque = new ArrayDeque<>();
        visited = new boolean[T + 1];

        deque.add(new int[]{0, 1});
        visited[0] = true;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            answer = Math.max(answer, cur[0]);

            int nextA = cur[0] + A;
            int nextB = cur[0] + B;
            int nextW = cur[0] / 2;
            if (nextA <= T && !visited[nextA]) {
                deque.add(new int[]{nextA, cur[1]});
                visited[nextA] = true;
            }
            if (nextB <= T && !visited[nextB]) {
                deque.add(new int[]{nextB, cur[1]});
                visited[nextB] = true;
            }

            if (cur[1] != 0 && !visited[nextW]) {
                deque.add(new int[]{nextW, 0});
                visited[nextW] = true;
            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        T = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        answer = Integer.MIN_VALUE;

        helper();

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}