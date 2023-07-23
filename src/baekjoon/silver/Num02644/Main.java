package baekjoon.silver.Num02644;

import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static int[] depth;

    private static int helper(int a, int b) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        depth[a] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == b) {
                return depth[cur] - 1;
            }
            for (int val : list[cur]) {
                if (depth[val] == 0) {
                    depth[val] += depth[cur] + 1;
                    queue.add(val);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        depth = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
        int answer = helper(a, b);
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
