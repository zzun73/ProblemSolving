package baekjoon.silver.Num13900;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long answer = 0;
        int cur = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            long X = Long.parseLong(st.nextToken());
            answer += cur * X;
            cur += X;

        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}