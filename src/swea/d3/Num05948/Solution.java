package swea.d3.Num05948;

import java.io.*;
import java.util.*;

public class Solution {
    private static final int SIZE = 7;
    static int[] arr;
    static boolean[] visited;
    static HashSet<Integer> set;

    public static void helper(int start, int count, int sum) {
        if (count >= 3) {
            set.add(sum);
            return;
        }

        for (int i = start; i < SIZE; i++) {
            if (!visited[i]) {
                visited[i] = true;
                helper(i, count + 1, sum + arr[i]);
                visited[i] = false;
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
            arr = new int[SIZE];
            set = new HashSet<>();
            visited = new boolean[SIZE];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < SIZE; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            helper(0, 0, 0);

            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            sb.append("#").append(t).append(" ").append(list.get(list.size() - 5)).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}