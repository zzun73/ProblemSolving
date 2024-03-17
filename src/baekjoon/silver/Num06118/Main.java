package baekjoon.silver.Num06118;

import java.io.*;
import java.util.*;

public class Main {
    static int[] helper(List<Integer>[] edges) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] distance = new int[edges.length];
        int maxDistance = 0;
        Arrays.fill(distance, -1);
        distance[1] = 0;
        deque.add(1);

        while (!deque.isEmpty()) {
            int cur = deque.poll();
            for (int next : edges[cur]) {
                if (distance[next] == -1) {
                    distance[next] = distance[cur] + 1;
                    maxDistance = Math.max(distance[next], maxDistance);
                    deque.add(next);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < distance.length; i++) {
            if (maxDistance == distance[i]) {
                list.add(i);
            }
        }
        return new int[]{list.get(0), maxDistance, list.size()};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List[] edges = new ArrayList[N + 1];
        for (int i = 1; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }
        int[] answer = helper(edges);
        sb.append(answer[0]).append(" ").append(answer[1]).append(" ").append(answer[2]);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}