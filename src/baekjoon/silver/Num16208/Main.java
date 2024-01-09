package baekjoon.silver.Num16208;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        long answer = 0;

        st = new StringTokenizer(br.readLine(), " ");
        arr[0] = Long.parseLong(st.nextToken());
        for (int i = 1; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            answer += arr[i - 1] * arr[i];
            arr[i] += arr[i - 1];
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}