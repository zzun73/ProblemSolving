package baekjoon.silver.Num23057;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static Set<Integer> set;
    static int[] arr;

    static void helper(int idx, int sum) {
        set.add(sum);
        if (idx == N) {
            return;
        }

        helper(idx + 1, sum + arr[idx]);
        helper(idx + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = 0;
        set = new HashSet<>();
        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            M += arr[i];
        }

        helper(0, 0);

        bw.write(String.valueOf(M - set.size() + 1));

        br.close();
        bw.close();
    }
}