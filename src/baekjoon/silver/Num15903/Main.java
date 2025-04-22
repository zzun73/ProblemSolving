package baekjoon.silver.Num15903;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        while (M-- > 0 && pq.size() >= 2) {
            long sum = pq.poll() + pq.poll();
            pq.add(sum);
            pq.add(sum);
        }

        long answer = 0;
        for (Long val : pq) {
            answer += val;
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}