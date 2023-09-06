package baekjoon.silver.Num02012;

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

        long answer = 0;
        for (int i = 0; i < N; i++) {
            answer += Math.abs((i + 1) - arr[i]);
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}
