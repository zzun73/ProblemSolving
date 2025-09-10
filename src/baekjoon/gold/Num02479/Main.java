package baekjoon.gold.Num02479;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] graph;
    static String[] str;
    static int[] path;

    static boolean isHamming(String s1, String s2) {
        int count = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }

        return count == 1;
    }

    static boolean helper(int A, int B) {
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];

        Arrays.fill(path, -1);
        visited[A] = true;
        deque.add(A);

        while (!deque.isEmpty()) {
            int cur = deque.poll();
            if (cur == B) {
                return true;
            }

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    path[next] = cur;
                    deque.add(next);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        str = new String[N + 1];
        path = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            str[i] = br.readLine();
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (isHamming(str[i], str[j])) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        boolean res = helper(A, B);

        if (res) {
            List<Integer> answer = new ArrayList<>();
            int cur = B;
            while (cur != -1) {
                answer.add(cur);
                if (cur == A) {
                    break;
                }
                cur = path[cur];
            }

            for (int i = answer.size() - 1; i >= 0; i--) {
                sb.append(answer.get(i)).append(" ");
            }

        } else {
            sb.append(-1);
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}