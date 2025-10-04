package baekjoon.silver.Num15565;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, count = 0, answer = Integer.MAX_VALUE;

        while (right < N) {
            if (arr[right++] == 1) {
                count++;
            }

            while (count >= K) {
                answer = Math.min(answer, right - left);
                if (arr[left++] == 1){
                    count--;
                }
            }
        }

        bw.write(String.valueOf(answer == Integer.MAX_VALUE ? -1 : answer));

        br.close();
        bw.close();
    }
}