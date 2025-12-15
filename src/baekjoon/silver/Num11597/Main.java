package baekjoon.silver.Num11597;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < N / 2; i++) {
            answer = Math.min(answer, arr[i] + arr[N - i - 1]);
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}