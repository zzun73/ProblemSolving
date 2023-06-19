package baekjoon.silver.Num11497;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] input = new int[N];
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                input[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(input);

            int answer = Integer.MIN_VALUE;
            int front = 0;
            int back = N - 1;
            for (int j = 0; j < N - 1; j += 2) {
                arr[front++] = input[j];
                arr[back--] = input[j + 1];
            }
            arr[N / 2] = input[N - 1];

            for (int j = 0; j < N - 1; j++) {
                answer = Math.max(answer, Math.abs(arr[j] - arr[j + 1]));
            }
            bw.write(answer + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
