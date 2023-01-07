package baekjoon.silver.Num06603;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static int k;
    static List<Integer> path;
    static boolean[] visited;

    public static void helper(int depth, int start) {
        if (depth == 6) {
            for (Integer integer : path) {
                sb.append(integer).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.add(arr[i]);
                helper(depth + 1, i);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }

            path = new ArrayList<>();
            arr = new int[k];
            visited = new boolean[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            helper(0, 0);
            bw.write(sb + "\n");
            sb.setLength(0);
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
