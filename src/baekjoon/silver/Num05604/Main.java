package baekjoon.silver.Num05604;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static List<Integer> path;

    static void helper(int idx, int sum) {
        if (sum == N) {
            for (int val : path) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        int start = Math.min(idx, N - sum);

        for (int i = start; i > 0; i--) {
            path.add(i);
            helper(i, sum + i);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        path = new ArrayList<>();
        helper(N, 0);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}