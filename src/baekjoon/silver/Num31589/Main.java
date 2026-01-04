package baekjoon.silver.Num31589;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long sum = arr[N - 1];
        int start = 0;
        int end = N - 2;
        K = (K - 1) / 2;
        while (K-- > 0) {
            sum += (long) arr[end--] - arr[start++];
        }

        bw.write(String.valueOf(sum));

        br.close();
        bw.close();
    }
}