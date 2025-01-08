package baekjoon.gold.Num14921;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left, right, answer;
        answer = Integer.MAX_VALUE;
        left = 0;
        right = N - 1;

        while (left < right) {
            int cur = arr[left] + arr[right];

            if (Math.abs(answer) > Math.abs(cur)) {
                answer = cur;
                if (answer == 0) {
                    break;
                }
            }

            if (cur > 0) {
                right--;
            } else {
                left++;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}