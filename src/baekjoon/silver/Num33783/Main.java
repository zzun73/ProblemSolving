package baekjoon.silver.Num33783;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Integer>[] list;

    static boolean helper(int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        deque.add(start);
        visited[start] = true;
        int count = 1;

        while (!deque.isEmpty()) {
            int cur = deque.poll();
            for (int next : list[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    deque.add(next);
                    count++;
                }
            }
        }
        return count == n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();

        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        bw.write(helper(s) ? "yes" : "no");

        br.close();
        bw.close();
    }
}