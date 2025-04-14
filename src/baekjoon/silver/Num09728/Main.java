package baekjoon.silver.Num09728;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;

    static int helper() {
        int start = 0, end = N - 1;
        int result = 0;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == M) {
                result++;
                start++;
                end--;
            } else if (sum < M) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            sb.append("Case #").append(t).append(": ").append(helper()).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}