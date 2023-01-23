package baekjoon.silver.Num06211;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int C, B;
    static int[] bucket;
    static int answer;

    public static void helper(int start, int sum) {
        answer = Math.max(answer, sum);

        for (int i = start; i < B; i++) {
            if (sum + bucket[i] < C) {
                helper(i + 1, sum + bucket[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        C = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        bucket = new int[B];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < B; i++) {
            bucket[i] = Integer.parseInt(st.nextToken());
        }

        answer = Integer.MIN_VALUE;
        helper(0, 0);

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
