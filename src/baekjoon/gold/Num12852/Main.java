package baekjoon.gold.Num12852;

import java.io.*;
import java.util.*;

public class Main {
    static int X;
    static int[] path;
    static List<Integer> answer;

    static void helper() {
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[X + 1];
        visited[X] = true;
        deque.add(X);

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            if (cur == 1) {
                break;
            }

            if (cur % 3 == 0 && !visited[cur / 3]) {
                path[cur / 3] = cur;
                visited[cur / 3] = true;
                deque.add(cur / 3);
            }

            if (cur % 2 == 0 && !visited[cur / 2]) {
                path[cur / 2] = cur;
                visited[cur / 2] = true;
                deque.add(cur / 2);
            }

            if (!visited[cur - 1]) {
                path[cur - 1] = cur;
                visited[cur - 1] = true;
                deque.add(cur - 1);
            }
        }


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        X = Integer.parseInt(br.readLine());
        answer = new ArrayList<>();
        path = new int[X + 1];

        helper();

        for (int v = 1; v != 0; v = path[v]) {
            answer.add(v);
        }
        Collections.reverse(answer);

        sb.append(answer.size() - 1).append("\n");
        for (int cur : answer) {
            sb.append(cur).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}