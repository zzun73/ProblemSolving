package baekjoon.silver.Num05848;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer>[] edges = new List[N + 1];
        boolean[] safe = new boolean[N + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            int val = Integer.parseInt(br.readLine());
            if (val == 0) {
                safe[i] = true;
                deque.add(i);
            } else {
                edges[val].add(i);
            }
        }

        int answer = 0;
        while (!deque.isEmpty()) {
            int cur = deque.poll();
            answer++;

            for (int next : edges[cur]) {
                if (!safe[next]) {
                    safe[next] = true;
                    deque.add(next);
                }
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}