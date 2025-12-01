package baekjoon.silver.Num06946;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int target;
    static int[] club;

    static int helper() {
        Deque<int[]> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[target + 1];

        visited[0] = true;
        deque.add(new int[]{0, 0});

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            if (cur[0] == target) {
                return cur[1];
            }

            for (int val : club) {
                int next = cur[0] + val;
                if (next > target || visited[next]) {
                    continue;
                }
                visited[next] = true;
                deque.add(new int[]{next, cur[1] + 1});
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        target = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        club = new int[N];
        for (int i = 0; i < N; i++) {
            club[i] = Integer.parseInt(br.readLine());
        }

        int result = helper();

        if (result == -1) {
            sb.append("Roberta acknowledges defeat.");
        } else {
            sb.append("Roberta wins in ").append(result).append(" strokes.");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}