package baekjoon.gold.Num13398;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] dp1 = new int[N + 1];
        int[] dp2 = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = dp1[1] = dp2[1] = arr[1];
        for (int i = 2; i <= N; i++) {
            dp1[i] = Math.max(arr[i], dp1[i - 1] + arr[i]);
            dp2[i] = Math.max(dp1[i - 1], dp2[i - 1] + arr[i]);

            answer = Math.max(answer, Math.max(dp1[i], dp2[i]));
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}