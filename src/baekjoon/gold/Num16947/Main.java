package baekjoon.gold.Num16947;

import java.io.*;
import java.util.*;

public class Main {

    static int N, cycleStart;
    static int[] distance;
    static List<Integer>[] edges;
    static boolean[] visited;
    static boolean[] isCycle;
    static boolean foundCycle;

    static boolean markCycle(int cur, int parent) {
        visited[cur] = true;

        for (int next : edges[cur]) {
            if (!visited[next]) {
                if (markCycle(next, cur)) {
                    if (!foundCycle) {
                        isCycle[cur] = true;
                    }
                    if (cur == cycleStart) {
                        foundCycle = true;
                    }
                    return true;
                }
            } else if (next != parent) {
                isCycle[cur] = true;
                cycleStart = next;
                return true;
            }
        }
        return false;
    }

    static void getDistance() {
        Arrays.fill(distance, -1);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (isCycle[i]) {
                distance[i] = 0;
                deque.add(i);
            }
        }

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            for (int next : edges[cur]) {
                if (distance[next] == -1) {
                    distance[next] = distance[cur] + 1;
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
        isCycle = new boolean[N + 1];
        visited = new boolean[N + 1];
        distance = new int[N + 1];
        foundCycle = false;
        cycleStart = -1;

        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[u].add(v);
            edges[v].add(u);
        }

        markCycle(1, -1);
        getDistance();

        for (int i = 1; i <= N; i++) {
            sb.append(distance[i]).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}