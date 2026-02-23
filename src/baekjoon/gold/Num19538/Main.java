package baekjoon.gold.Num19538;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] answer;
    static List<Integer>[] edges;
    static Deque<Integer> deque;

    static void helper() {

        int[] connected = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            connected[i] = (edges[i].size() + 1) / 2;
        }

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            for (int next : edges[cur]) {
                if (answer[next] != -1) {
                    continue;
                }

                if (--connected[next] == 0) {
                    answer[next] = answer[cur] + 1;
                    deque.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        edges = new ArrayList[N + 1];
        for (int cur = 1; cur <= N; cur++) {
            edges[cur] = new ArrayList<>();

            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                int target = Integer.parseInt(st.nextToken());
                if (target == 0) {
                    break;
                }
                edges[cur].add(target);
            }
        }

        answer = new int[N + 1];
        Arrays.fill(answer, -1);
        deque = new ArrayDeque<>();

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int cur = Integer.parseInt(st.nextToken());
            deque.add(cur);
            answer[cur] = 0;
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