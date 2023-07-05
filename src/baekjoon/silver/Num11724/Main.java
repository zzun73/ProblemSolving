package baekjoon.silver.Num11724;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void helper(int start, List<List<Integer>> list, boolean[] visited) {
        visited[start] = true;
        for (int val : list.get(start)) {
            if (!visited[val]) {
                helper(val, list, visited);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        List<List<Integer>> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                helper(i, list, visited);
                answer++;
            }
        }
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
