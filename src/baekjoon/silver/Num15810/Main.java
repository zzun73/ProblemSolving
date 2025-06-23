package baekjoon.silver.Num15810;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;

    static boolean helper(long time) {
        long count = 0;

        for (int val : arr) {
            count += time / val;
        }

        return count >= M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        long low = 0;
        long high = 0;
        long answer = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high, arr[i]);
        }
        high *= M;

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