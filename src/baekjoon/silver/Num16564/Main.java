package baekjoon.silver.Num16564;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] arr;

    static boolean helper(long mid) {
        long sum = 0;
        for (int val : arr) {
            sum += (mid > val) ? mid - val : 0;
        }
        return sum <= K;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        long low = Long.MAX_VALUE;
        long high = 0;
        long answer = 0;
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            arr[i] = val;
            low = Math.min(arr[i], low);
            high = Math.max(arr[i], high);
        }
        high += K;

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