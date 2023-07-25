package baekjoon.silver.Num02003;

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

        int start = 0, end = 0, cur = 0, answer = 0;
        while (start < N && end < N) {
            cur += arr[end++];
            if (cur > M) {
                while (cur > M) {
                    cur -= arr[start++];
                }
            }

            if (cur == M) {
                answer++;
            }
        }

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();

    }
}
