package baekjoon.bronze.Num10872;

import java.io.*;

public class Main {
    public static int helper(int N) {
        if (N <= 1) return 1;
        return N * helper(N - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = helper(N);
        System.out.println(answer);
        br.close();
    }

}
