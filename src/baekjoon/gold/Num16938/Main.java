package baekjoon.gold.Num16938;

import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R, X;
    static int answer, min, goal;
    static int[] arr;

    public static void helper(int start, int depth, int pick, int max, int sum) {
        if (depth == goal) {
            if (pick > 1) {
                if (max - min >= X && L <= sum && sum <= R) {
                    answer++;
                }
            }
            return;
        }

        for (int i = start; i < N; i++) {
            helper(i + 1, depth + 1, pick + 1, arr[i], sum + arr[i]);
            helper(i + 1, depth + 1, pick, max, sum);

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for (int i = 0; i < N - 1; i++) {
            min = arr[i];
            goal = N - i;
            helper(i + 1, 1, 1, arr[i], arr[i]);

        }
        System.out.println(answer);

        br.close();
    }
}
