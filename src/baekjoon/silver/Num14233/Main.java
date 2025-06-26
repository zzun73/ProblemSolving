package baekjoon.silver.Num14233;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    static boolean helper(long mid) {
        for (int i = 0; i < N; i++) {
            long result = arr[i] - (i + 1) * mid;
            if (result < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        long low = 0, high = 0, answer = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = val;
            high = Math.max(high, val);
        }
        Arrays.sort(arr);

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