package baekjoon.silver.Num11725;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] answer;
    static boolean[] visited;

    public static void helper(List<List<Integer>> list, int start) {
        if (visited[start]) {
            return;
        }
        visited[start] = true;
        for (int val : list.get(start)) {
            if (!visited[val]) {
                answer[val] = start;
                helper(list, val);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        answer = new int[N + 1];
        visited = new boolean[N + 1];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < answer.length; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i < answer.length - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }

        helper(list, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < answer.length; i++) {
            sb.append(answer[i]).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
