package baekjoon.silver.Num01654;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static long[] arr;

    static boolean helper(long length) {
        long result = 0;
        for (long val : arr) {
            result += val / length;
        }
        return result >= N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new long[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long low = 1;
        long high = arr[arr.length - 1];
        long answer = 0;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (helper(mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}