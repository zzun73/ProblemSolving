package baekjoon.silver.Num13305;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] distance = new long[N - 1];
        long[] cost = new long[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        long answer = distance[0] * cost[0];
        long cur = cost[0];
        for (int i = 1; i < N - 1; i++) {
            cur = Math.min(cur, cost[i]);
            answer += distance[i] * cur;
        }

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
