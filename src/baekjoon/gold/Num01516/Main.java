package baekjoon.gold.Num01516;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] indegree = new int[N + 1];
        int[] answer = new int[N + 1];
        int[] cost = new int[N + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer>[] list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int target = 1; target <= N; target++) {
            st = new StringTokenizer(br.readLine(), " ");
            int time = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            cost[target] = time;

            while (prev != -1) {
                list[prev].add(target);
                indegree[target]++;
                prev = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                answer[i] = cost[i];
            }
        }

        while (!queue.isEmpty()) {
            int startId = queue.poll();
            for (int val : list[startId]) {
                indegree[val]--;
                answer[val] = Math.max(answer[val], answer[startId] + cost[val]);

                if (indegree[val] == 0) queue.add(val);
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
