package baekjoon.silver.Num06236;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[] arr;

    static boolean helper(int k) {
        int count = 0;
        int money = 0;

        for (int val : arr) {
            if (money < val) {
                count++;
                money = k;
            }
            money -= val;
        }

        return count <= M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        int low = 0;
        int high = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            low = Math.max(low, arr[i]);
            high += arr[i];
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            if (helper(mid)) {
                K = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        bw.write(String.valueOf(K));

        br.close();
        bw.close();
    }
}