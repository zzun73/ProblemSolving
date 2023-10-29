package baekjoon.silver.Num14225;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] S;
    static boolean[] checked;

    public static void helper(int idx, int pathSum) {
        if (idx == N) {
            checked[pathSum] = true;
            return;
        }
        helper(idx + 1, pathSum + S[idx]);
        helper(idx + 1, pathSum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        S = new int[N];
        int maxSum = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
            maxSum += S[i];
        }
        checked = new boolean[maxSum + 1];

        helper(0, 0);
        int answer = maxSum + 1;
        for (int i = 1; i <= maxSum; i++) {
            if (!checked[i]) {
                answer = i;
                break;
            }
        }
        bw.write(String.valueOf(answer));
        br.close();
        bw.flush();
        bw.close();
    }
}