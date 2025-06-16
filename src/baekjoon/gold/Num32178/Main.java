package baekjoon.gold.Num32178;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Pair implements Comparable<Pair> {
        long sum;
        int idx;

        public Pair(long sum, int idx) {
            this.sum = sum;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair o) {
            return Long.compare(o.sum, this.sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N + 1];
        Pair[] pairs = new Pair[N + 1];
        pairs[0] = new Pair(0L, 0);

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            long cur = Long.parseLong(st.nextToken());
            arr[i] = cur + arr[i - 1];
            pairs[i] = new Pair(arr[i], i);
        }
        Arrays.sort(pairs);

        int L = 1, R = 1;
        long answerDiff = Long.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            long diff = Math.abs(pairs[i].sum - pairs[i - 1].sum);
            if (diff < answerDiff) {
                answerDiff = diff;

                int idx1 = pairs[i].idx;
                int idx2 = pairs[i - 1].idx;
                L = Math.min(idx1, idx2) + 1;
                R = Math.max(idx1, idx2);
            }
        }

        sb.append(arr[R] - arr[L - 1]).append("\n").append(L).append(" ").append(R);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}