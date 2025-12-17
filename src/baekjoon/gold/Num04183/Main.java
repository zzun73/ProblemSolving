package baekjoon.gold.Num04183;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Set<Integer> set = new HashSet<>();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            int answer = 0;
            int left = 0, right = 0;
            while (right < N) {
                if (!set.contains(arr[right])) {
                    set.add(arr[right]);
                    right++;
                    answer = Math.max(answer, right - left);
                } else {
                    set.remove(arr[left]);
                    left++;
                }
            }
            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}