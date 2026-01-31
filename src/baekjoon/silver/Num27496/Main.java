package baekjoon.silver.Num27496;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = arr[i - 1] + val;
        }

        int answer = 0;
        for (int right = 1; right <= N; right++) {
            int left = Math.max(0, right - L);
            int sum = arr[right] - arr[left];

            if (129 <= sum && sum <= 138) {
                answer++;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}