package baekjoon.silver.Num20044;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int len = 2 * N;
        int[] arr = new int[len];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= N; i++) {
            int cur = arr[i] + arr[len - i - 1];
            answer = Math.min(answer, cur);
        }
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
