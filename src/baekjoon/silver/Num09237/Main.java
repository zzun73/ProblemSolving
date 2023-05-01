package baekjoon.silver.Num09237;

import java.io.*;
import java.util.Arrays;
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
        Arrays.sort(arr);

        int day = 2;
        int answer = 0;
        for (int i = N - 1; i >= 0; i--) {
            answer = Math.max(answer, arr[i] + day);
            day++;
        }
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
