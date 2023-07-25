package baekjoon.gold.Num02096;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, cur = 0, answer = Integer.MAX_VALUE;

        while (end < N) {
            cur += arr[end++];
            while (cur >= M) {
                answer = Math.min(answer, end - start);
                cur -= arr[start++];
            }
        }
        bw.write((answer == Integer.MAX_VALUE) ? "0" : String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}
