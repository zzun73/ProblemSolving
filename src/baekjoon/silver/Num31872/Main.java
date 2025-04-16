package baekjoon.silver.Num31872;

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
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int start = 0;
        int[] distance = new int[N];
        for (int i = 0; i < N; i++) {
            distance[i] = arr[i] - start;
            start = arr[i];
        }
        Arrays.sort(distance);

        int answer = 0;
        for (int i = 0; i < N - K; i++) {
            answer += distance[i];
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}