package baekjoon.silver.Num02559;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            arr[i] += Integer.parseInt(st.nextToken()) + arr[i - 1];
        }

        int answer = arr[K];
        for (int i = 1; i <= N - K; i++) {
            answer = Math.max(answer, arr[K + i] - arr[i]);
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}