package baekjoon.bronze.Num02309;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int size;
    static int[] arr;
    static boolean[] visited;
    static boolean flag;
    static StringBuilder sb;

    public static void helper(int len, int sum) {
        if (flag) {
            return;
        }

        if (len == 7 && sum == 100) {
            for (int i = 0; i < size; i++) {
                if (visited[i]) {
                    sb.append(arr[i]).append("\n");
                }
            }
            flag = true;
            return;
        }

        for (int i = 0; i < size; i++) {
            if (!visited[i] && sum + arr[i] <= 100) {
                visited[i] = true;
                helper(len + 1, sum + arr[i]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        size = 9;
        arr = new int[size];
        visited = new boolean[size];
        flag = false;
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        helper(0, 0);

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}