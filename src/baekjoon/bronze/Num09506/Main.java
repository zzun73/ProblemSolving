package baekjoon.bronze.Num09506;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == -1) {
                break;
            }

            int[] numbers = new int[N];
            int sum = 0;
            int index = 0;
            for (int i = 1; i < N; i++)
                if (N % i == 0) {
                    numbers[index++] = i;
                    sum += i;
                }

            if (sum != N) {
                bw.write(N + " is NOT perfect.\n");
                continue;
            }

            bw.write(N + " = ");
            for (int i = 0; i < index; i++) {
                bw.write(numbers[i] + "");
                if (i + 1 != index)
                    bw.write(" + ");
            }
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
