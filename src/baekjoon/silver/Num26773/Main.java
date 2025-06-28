package baekjoon.silver.Num26773;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    static boolean helper(long mid) {
        long sum = 0;
        for (int val : arr) {
            sum += (val / mid);
        }
        return sum >= 4;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        long low = 1, high = 0, answer = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = val;
            low = Math.min(low, val);
            high = Math.max(high, val);
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

        bw.write(String.valueOf(answer * answer));

        br.close();
        bw.close();
    }
}