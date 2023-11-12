package swea.d3.Num02814;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static int N, answer;
    static List<Integer>[] list;
    static boolean[] visited;

    public static void helper(int cur, int count) {
        visited[cur] = true;
        answer = Math.max(count, answer);
        for (int next : list[cur]) {
            if (!visited[next]) {
                helper(next, count + 1);
                visited[next] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            answer = 0;
            list = new ArrayList[N + 1];
            visited = new boolean[N + 1];

            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list[x].add(y);
                list[y].add(x);
            }
            for (int i = 1; i <= N; i++) {
                helper(i, 1);
                visited[i] = false;
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}