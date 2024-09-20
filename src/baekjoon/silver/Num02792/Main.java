package baekjoon.silver.Num02792;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];
        int max = 0;
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        int left = 1, right = max, answer = 0;

        while (left <= right) {
            int mid = (left + right) >> 1;

            int count = 0;
            for (int i = 0; i < M; i++) {
                count += ((arr[i] - 1) / mid) + 1;
            }

            if (count > N) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}