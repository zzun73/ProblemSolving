package baekjoon.bronze.Num10870;

import java.io.*;

public class Main {
    public static int helper(int N) {
        if (N <= 1) return N;
        return helper(N - 1) + helper(N - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(helper(N));
        br.close();
    }
}
