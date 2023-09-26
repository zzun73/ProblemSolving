package baekjoon.silver.Num02491;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int answer = 1;
        int[] arr = new int[N];
        int[] ascDp = new int[N];
        int[] descDp = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        arr[0] = Integer.parseInt(st.nextToken());
        descDp[0] = ascDp[0] = 1;

        for (int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (arr[i] > arr[i - 1]) {
                ascDp[i] = ascDp[i - 1] + 1;
                descDp[i] = 1;
            } else if (arr[i] < arr[i - 1]) {
                descDp[i] = descDp[i - 1] + 1;
                ascDp[i] = 1;
            } else {
                ascDp[i] = ascDp[i - 1] + 1;
                descDp[i] = descDp[i - 1] + 1;
            }
            answer = Math.max(Math.max(ascDp[i], descDp[i]), answer);
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}