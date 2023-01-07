package baekjoon.silver.Num01182;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, S, answer;
    static int[] arr;

    public static void helper(int depth, int sum) {
        if (depth == N) {
            if (sum == S) {
                answer++;
            }
            return;
        }

        helper(depth + 1, sum + arr[depth]);
        helper(depth + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        helper(0, 0);
        if (S == 0) {
            bw.write(answer - 1 + "");
        } else {
            bw.write(answer + "");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
