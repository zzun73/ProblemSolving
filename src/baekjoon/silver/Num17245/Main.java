package baekjoon.silver.Num17245;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long half;
    static int[][] arr;


    static boolean helper(int mid) {
        long sum = 0;

        for (int[] row : arr) {
            for (int val : row) {
                sum += Math.min(val, mid);
            }
        }
        return sum >= half;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        int low = 0;
        int high = 0;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                arr[i][j] = val;
                half += val;
                high = Math.max(high, val);
            }
        }

        half = (half + 1) / 2;
        while (low <= high) {
            int mid = (low + high) / 2;
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