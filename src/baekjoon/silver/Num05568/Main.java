package baekjoon.silver.Num05568;

import java.io.*;
import java.util.*;

public class Main {

    private static int n, k;
    private static int[] arr;
    private static boolean[] visited;
    private static HashSet<String> set;

    private static void helper(int count, List<Integer> path) {
        if (count == k) {
            StringBuilder sb = new StringBuilder();
            for (int value : path) {
                sb.append(value);
            }
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.add(arr[i]);
                helper(count + 1, path);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        helper(0, new ArrayList<>());

        bw.write(set.size() + "");

        br.close();
        bw.flush();
        bw.close();

    }
}
