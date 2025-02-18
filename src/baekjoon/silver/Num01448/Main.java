package baekjoon.silver.Num01448;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int answer = -1;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for (int i = 0; i < N - 2; i++) {
            if (arr[i] + arr[i + 1] > arr[i + 2]) {
                answer = Math.max(arr[i] + arr[i + 1] + arr[i + 2], answer);
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}