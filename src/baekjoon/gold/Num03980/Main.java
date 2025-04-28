package baekjoon.gold.Num03980;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final int SIZE = 11;
    static int answer;
    static int[][] arr;

    static boolean[] picked;

    static void helper(int depth, int sum) {

        if (depth == SIZE) {
            answer = Math.max(sum, answer);
            return;
        }

        for (int i = 0; i < SIZE; i++) {
            if (picked[i] || arr[depth][i] == 0) {
                continue;
            }
            picked[i] = true;
            helper(depth + 1, sum + arr[depth][i]);
            picked[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            answer = 0;
            arr = new int[SIZE][SIZE];
            picked = new boolean[SIZE];
            for (int i = 0; i < SIZE; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < SIZE; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            helper(0, 0);

            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}