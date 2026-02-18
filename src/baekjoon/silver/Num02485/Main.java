package baekjoon.silver.Num02485;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int helper(int a, int b) {
        if (b == 0) {
            return a;
        }
        return helper(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int prev = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int gcd = 0;
        for (int i = 1; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());
            list.add(cur - prev);
            gcd = helper(gcd, list.get(i - 1));
            prev = cur;
        }

        int answer = 0;
        for (int val : list) {
            answer += val / gcd - 1;
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}