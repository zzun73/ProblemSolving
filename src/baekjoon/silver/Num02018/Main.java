package baekjoon.silver.Num02018;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        int start = 1, end = 1;
        int sum = 0, answer = 0;
        while (start <= N) {
            if (sum >= N) {
                sum -= arr[start++];
            } else {
                sum += arr[end++];
            }

            if (sum == N) {
                answer++;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}
