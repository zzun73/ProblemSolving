package baekjoon.silver.Num02217;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] rope = new int[N];

        for (int i = 0; i < N; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope);

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, rope[i] * (N - i));
        }

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
