package baekjoon.silver.Num02303;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final int SIZE = 5;

    static int N, curMax;
    static int[] arr;
    static boolean[] visited;

    static void helper(int depth, int sum) {
        if (depth == 3) {
            curMax = Math.max(curMax, sum % 10);
            return;
        }

        for (int i = 0; i < SIZE; i++) {
            if (!visited[i]) {
                visited[i] = true;
                helper(depth + 1, sum + arr[i]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int answer = 1;
        int totalMax = 0;
        visited = new boolean[SIZE];

        for (int i = 0; i < N; i++) {
            curMax = 0;
            arr = new int[SIZE];

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < SIZE; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            helper(0, 0);

            if (totalMax <= curMax) {
                totalMax = curMax;
                answer = i + 1;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}