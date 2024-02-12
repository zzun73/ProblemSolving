package baekjoon.silver.Num01074;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, r, c;
    static int answer;

    static void helper(int N, int r, int c) {
        if (N == 1) {
            return;
        }

        int size = N / 2;

        if (r < size && c < size) { // 1사분면
            helper(size, r, c);
        } else if (r < size && c >= size) { // 2사분면
            answer += N * N / 4;
            helper(size, r, c - size);
        } else if (r >= size && c < size) { // 3사분면
            answer += N * N / 4 * 2;
            helper(size, r - size, c);
        } else { // 4사분면
            answer += N * N / 4 * 3;
            helper(size, r - size, c - size);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        answer = 0;

        helper((int) Math.pow(2, N), r, c);

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}
