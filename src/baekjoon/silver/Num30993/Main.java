package baekjoon.silver.Num30993;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int helper(int n, int m) {
        if (n <= 1 || m == 0 || m == n) {
            return 1;
        }

        return helper(n - 1, m - 1) + helper(n - 1, m);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int answer = helper(N, A) * helper(N - A, B);


        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}