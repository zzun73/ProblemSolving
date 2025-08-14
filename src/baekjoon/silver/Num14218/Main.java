package baekjoon.silver.Num14218;

import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;

    static int[] helper(int N) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1);

        Deque<Integer> deque = new ArrayDeque<>();
        distance[1] = 0;
        deque.add(1);

        while (!deque.isEmpty()) {
            int cur = deque.poll();
            for (int next : graph[cur]) {
                if (distance[next] == -1) {
                    distance[next] = distance[cur] + 1;
                    deque.add(next);
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        int Q = Integer.parseInt(br.readLine());

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);

            int[] answer = helper(N);

            for (int i = 1; i <= N; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
