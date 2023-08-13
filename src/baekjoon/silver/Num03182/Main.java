package baekjoon.silver.Num03182;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer>[] list;
    static boolean[] visited;

    public static int helper(int start) {
        int sum = 0;
        visited[start] = true;
        for (Integer next : list[start]) {
            if (!visited[next]) {
                sum = 1 + helper(next);
            }
        }
        visited[start] = false;
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int maxValue = 0, answer = 0;
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            int target = Integer.parseInt(br.readLine());
            list[i].add(target);
        }
        for (int i = 1; i <= N; i++) {
            int temp = helper(i);
            if (maxValue < temp) {
                maxValue = temp;
                answer = i;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}
