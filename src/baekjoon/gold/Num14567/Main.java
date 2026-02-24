package baekjoon.gold.Num14567;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] inDegree;
    static int[] answer;
    static List<Integer>[] edges;


    static void helper() {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                deque.add(i);
                answer[i] = 1;
            }
        }

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            for (int next : edges[cur]) {
                if (--inDegree[next] == 0) {
                    deque.add(next);
                    answer[next] = answer[cur] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        inDegree = new int[N + 1];
        answer = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            edges[A].add(B);
            inDegree[B]++;
        }

        helper();

        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}