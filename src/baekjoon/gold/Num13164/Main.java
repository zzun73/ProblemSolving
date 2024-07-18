package baekjoon.gold.Num13164;

import java.io.*;
import java.util.Arrays;
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
        int[] diff = new int[N - 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            diff[i] = Math.abs(arr[i + 1] - arr[i]);
        }
        Arrays.sort(diff);

        int answer = 0;
        for (int i = 0; i < N - K; i++) {
            answer += diff[i];
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}