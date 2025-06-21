package baekjoon.silver.Num13702;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;

    static boolean helper(long mid) {
        if (mid == 0) {
            return true;
        }
        int count = 0;

        for (int val : arr) {
            count += (int) (val / mid);
        }
        return count >= K;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        long low = 0;
        long high = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            high += arr[i];
        }

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