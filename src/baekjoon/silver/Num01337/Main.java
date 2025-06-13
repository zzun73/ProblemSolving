package baekjoon.silver.Num01337;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int left = 0;
        int answer = 5;
        while (left < N && answer > 0) {
            int right = Math.min(left + 5, N);
            int count = 0;
            for (int i = left; i < right; i++) {
                if (arr[i] - arr[left] <= 4) {
                    count++;
                }
            }
            left++;
            answer = Math.min(answer, 5 - count);
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}