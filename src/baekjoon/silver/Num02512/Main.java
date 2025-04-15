package baekjoon.silver.Num02512;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int answer = 0, left = 0, right = arr[N - 1];
        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0L;

            for (int val : arr) {
                sum += Math.min(val, mid);
            }

            if (sum <= M) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }


        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}