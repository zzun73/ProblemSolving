package baekjoon.silver.Num01426;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int[] answer = new int[2];
        int count = 1;
        for (int i = M - 1; i >= 0; i--) {
            int curPeople = Math.min(count, N);

            if (answer[1] < arr[i] * curPeople) {
                answer[0] = arr[i];
                answer[1] = arr[i] * curPeople;
            }
            count++;
        }
        sb.append(answer[0]).append(" ").append(answer[1]);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}