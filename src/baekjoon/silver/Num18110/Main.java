package baekjoon.silver.Num18110;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int removeCount = (int) Math.round(N * 0.15);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for (int i = 0; i < removeCount; i++) {
            arr[i] = 0;
            arr[arr.length - i - 1] = 0;
        }

        int sum = 0;
        for (int val : arr) {
            sum += val;
        }
        int answer = (int) Math.round((double) sum / (N - removeCount - removeCount));

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}