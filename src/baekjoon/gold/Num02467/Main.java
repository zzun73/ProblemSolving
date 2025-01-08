package baekjoon.gold.Num02467;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[2];
        int left, right, sum;
        sum = Integer.MAX_VALUE;
        left = 0;
        right = N - 1;

        while (left < right) {
            int cur = arr[left] + arr[right];

            if (Math.abs(sum) > Math.abs(cur)) {

                sum = cur;
                answer[0] = arr[left];
                answer[1] = arr[right];

                if (sum == 0) {
                    break;
                }
            }

            if (cur > 0) {
                right--;
            } else {
                left++;
            }
        }

        sb.append(answer[0]).append(" ").append(answer[1]);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}