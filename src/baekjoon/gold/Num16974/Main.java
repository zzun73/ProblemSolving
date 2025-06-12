package baekjoon.gold.Num16974;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long[] bugger;
    static long[] patty;

    static long helper(int level, long x) {
        if (level == 0) {
            return x >= 1 ? 1 : 0;
        }

        if (x == 1) {
            return 0;
        } else if (x <= 1 + bugger[level - 1]) {
            return helper(level - 1, x - 1);
        } else if (x == 2 + bugger[level - 1]) {
            return patty[level - 1] + 1;
        } else if (x <= 2 + bugger[level - 1] + bugger[level - 1]) {
            return patty[level - 1] + 1 + helper(level - 1, x - 2 - bugger[level - 1]);
        } else {
            return patty[level];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());

        bugger = new long[51];
        patty = new long[51];
        bugger[0] = 1;
        patty[0] = 1;

        for (int i = 1; i <= N; i++) {
            bugger[i] = 2 * bugger[i - 1] + 3;
            patty[i] = 2 * patty[i - 1] + 1;
        }

        bw.write(String.valueOf(helper(N, X)));

        br.close();
        bw.close();
    }
}