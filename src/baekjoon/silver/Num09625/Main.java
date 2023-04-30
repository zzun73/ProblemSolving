package baekjoon.silver.Num09625;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        int[] A = new int[K + 1];
        int[] B = new int[K + 1];
        A[0] = 1;
        B[0] = 0;
        for (int i = 1; i <= K; i++) {
            A[i] = B[i - 1];
            B[i] = A[i - 1] + B[i - 1];
        }
        bw.write(A[K] + " " + B[K]);

        br.close();
        bw.flush();
        bw.close();
    }
}
