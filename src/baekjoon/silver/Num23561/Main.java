package baekjoon.silver.Num23561;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N * 3 + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N * 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        bw.write(String.valueOf(arr[N + N] - arr[N + 1]));

        br.close();
        bw.close();
    }
}