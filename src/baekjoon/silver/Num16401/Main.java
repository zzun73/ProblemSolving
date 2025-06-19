package baekjoon.silver.Num16401;

import java.io.*;
import java.util.*;

public class Main {

    static int M, N;
    static int[] arr;

    static boolean helper(long length) {
        if (length == 0) {
            return true;
        }

        int count = 0;

        for (int val : arr) {
            if (val >= length) {
                count += (int) (val / length);
            }
        }
        return count >= M;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        long low = 0;
        long high = 0;
        long answer = 0;
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = val;
            high = Math.max(high, arr[i]);
            low = Math.min(low, arr[i]);
        }

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