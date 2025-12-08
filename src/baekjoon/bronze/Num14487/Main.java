package baekjoon.bronze.Num14487;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int sum = 0, max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            sum += val;
            max = Math.max(max, val);
        }
        sum-=max;

        bw.write(String.valueOf(sum));

        br.close();
        bw.close();
    }
}