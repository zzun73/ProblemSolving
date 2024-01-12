package baekjoon.silver.Num28075;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer;
    static int[] arr;

    static void helper(int count, int prev, int sum) {
        if (count == N) {
            if (sum >= M) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if ((prev % 3) == (i % 3)) {
                helper(count + 1, i, sum + arr[i] / 2);
            } else {
                helper(count + 1, i, sum + arr[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[6];
        answer = 0;
        int idx = 0;
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < arr.length; i++) {
            helper(1, i, arr[i]);
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}