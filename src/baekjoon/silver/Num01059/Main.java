package baekjoon.silver.Num01059;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int L = Integer.parseInt(br.readLine());
        int[] arr = new int[L];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < L; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int N = Integer.parseInt(br.readLine());
        int answer = 0, left = Integer.MIN_VALUE, right = Integer.MAX_VALUE;
        for (int i = 0; i < L ; i++) {
            if (arr[i] < N) {
                left = Math.max(arr[i] + 1, left);
            } else if (arr[i] > N) {
                right = Math.min(arr[i] - 1, right);
            } else {
                left = right = 0;
                break;
            }
        }
        if (left != right) {
            if (left == Integer.MIN_VALUE) {
                left = 1;
            }
            if (right == Integer.MAX_VALUE) {
                right = arr[L - 1] - 1;
            }
            for (int i = left; i <= N; i++) {
                for (int j = N; j <= right; j++) {
                    if (i == j) continue;
                    answer++;
                }
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}