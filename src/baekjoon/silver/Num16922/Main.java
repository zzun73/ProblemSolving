package baekjoon.silver.Num16922;

import java.io.*;

public class Main {
    static int N, answer;
    static boolean[] visited;
    static int[] romaNumber;

    public static void helper(int depth, int start, int sum) {
        if (depth == N) {
            if (!visited[sum]) {
                visited[sum] = true;
                answer++;
            }
            return;
        }
        for (int i = start; i < 4; i++) {
            helper(depth + 1, i, sum + romaNumber[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        romaNumber = new int[]{1, 5, 10, 50};
        visited = new boolean[1001];
        answer = 0;
        helper(0, 0, 0);

        System.out.println(answer);
        br.close();
    }
}
