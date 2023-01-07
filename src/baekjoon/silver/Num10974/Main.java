package baekjoon.silver.Num10974;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static List<Integer> path;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void helper(int depth) {
        if (depth == N) {
            for (Integer integer : path) {
                sb.append(integer).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.add(i + 1);
                helper(depth + 1);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        path = new ArrayList<>();

        helper(0);
        bw.write(sb + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
