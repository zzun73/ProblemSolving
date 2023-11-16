package baekjoon.silver.Num05883;

import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            set.add(arr[i]);
        }

        int answer = 1;
        for (int val : set) {
            int len = 1;
            int prev = arr[0];
            for (int i = 1; i < N; i++) {
                if (arr[i] == val) {
                    continue;
                } else if (prev != arr[i]) {
                    len = 1;
                } else {
                    len++;
                    answer = Math.max(answer, len);
                }
                prev = arr[i];
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}