package baekjoon.gold.Num12738;

import java.io.*;
import java.util.*;

public class Main {
    static int binarySearch(int[] memo, int start, int end, int target) {

        while (start < end) {
            int mid = (start + end) / 2;
            if (memo[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] memo = new int[N + 1];
        memo[0] = Integer.MIN_VALUE;
        int len = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur > memo[len]) {
                memo[++len] = cur;
            } else {
                int idx = binarySearch(memo, 0, len, cur);
                memo[idx] = cur;
            }
        }
        bw.write(String.valueOf(len));
        br.close();
        bw.close();
    }
}