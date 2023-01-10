package baekjoon.silver.Num01978;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[] prime;

    public static void make_prime(int range) {
        prime = new boolean[range + 1];
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= Math.sqrt(range); i++) {
            if (prime[i]) {
                continue;
            }

            for (int j = i * i; j < range + 1; j = j + i) {
                prime[j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        make_prime(1000);

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {

            int X = Integer.parseInt(st.nextToken());
            if (!prime[X]) {
                answer++;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
