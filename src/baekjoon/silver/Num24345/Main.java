package baekjoon.silver.Num24345;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;


    static boolean helper(long mid) {
        long count = 0;
        for (int val : arr) {
            count += mid / val;
        }
        return count >= N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[K];

        long low = 0, high = 0, answer = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < K; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = val;
            high = Math.max(arr[i], high);
        }
        high *= N;

        while (low <= high) {
            long mid = (low + high) / 2;
            if (helper(mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}