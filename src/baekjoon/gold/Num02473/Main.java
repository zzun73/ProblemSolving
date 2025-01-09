package baekjoon.gold.Num02473;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] arr, answer;

    private static void helper() {
        long sum = Long.MAX_VALUE;

        Arrays.sort(arr);

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            if (sum == 0) {
                break;
            }

            while (left < right) {
                long cur = arr[i] + arr[left] + arr[right];

                if (Math.abs(cur) < Math.abs(sum)) {
                    sum = cur;
                    answer[0] = arr[i];
                    answer[1] = arr[left];
                    answer[2] = arr[right];
                }

                if (cur > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        answer = new long[3];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        helper();

        for (long val : answer) {
            sb.append(val).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}