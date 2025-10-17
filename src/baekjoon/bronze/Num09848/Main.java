package baekjoon.bronze.Num09848;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int prev = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 1; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());
            if (prev - cur >= K) {
                answer++;
            }
            prev = cur;
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}