package baekjoon.silver.Num01049;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[0] = Math.min(arr[0], Integer.parseInt(st.nextToken()));
            arr[1] = Math.min(arr[1], Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        if (N > 6) {
            int val = Math.min(arr[0], arr[1] * 6);
            answer += N / 6 * val;
            N %= 6;
        }
        if (N > 0) {
            int val = Math.min(arr[0], arr[1] * N);
            answer += val;
        }
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
