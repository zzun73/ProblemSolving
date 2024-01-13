package baekjoon.silver.Num01812;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        sum /= 2;
        int count = (N + 1) / 2;
        for (int i = 0; i < N; i++) {
            int temp = 0, cur = 0;
            for (int j = i; temp < count; temp++, j += 2) {
                j %= N;
                cur += arr[j];
            }
            sb.append(cur - sum).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}