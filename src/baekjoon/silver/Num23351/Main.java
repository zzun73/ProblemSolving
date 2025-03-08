package baekjoon.silver.Num23351;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        Arrays.fill(arr, K);

        int day = 0;
        while (arr[0] > 0) {
            for (int i = 0; i < A; i++) {
                arr[i] += B;
            }
            for (int i = 0; i < N; i++) {
                arr[i] -= 1;
            }
            Arrays.sort(arr);
            day++;
        }

        bw.write(String.valueOf(day));

        br.close();
        bw.close();
    }
}