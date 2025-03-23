package baekjoon.gold.Num02668;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] visited;
    static int[] arr;
    static List<Integer> list;

    static void helper(int index, int value) {
        if (arr[index] == value) {
            list.add(index);
            return;
        }

        if (!visited[index]) {
            visited[index] = true;
            helper(arr[index], value);
            visited[index] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            helper(i, i);

        }

        Collections.sort(list);
        sb.append(list.size()).append('\n');
        for (int val : list) {
            sb.append(val).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}