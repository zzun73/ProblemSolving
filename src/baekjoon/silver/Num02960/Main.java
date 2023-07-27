package baekjoon.silver.Num02960;

import java.io.*;
import java.util.*;

public class Main {
    static boolean[] prime;

    private static int helper(int N, int K) {
        int cnt = 0;
        prime[0] = prime[1] = true;
        for (int i = 2; i <= N; i++) {
            if (prime[i]) continue;

            for (int j = i; j < prime.length; j += i) {
                if (!prime[j]) {
                    prime[j] = true;
                    cnt++;

                    if (cnt == K) return j;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        prime = new boolean[N + 1];
        bw.write(helper(N, K) + "");

        br.close();
        bw.flush();
        bw.close();

    }
}