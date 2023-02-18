package baekjoon.silver.Num15577;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Double> pq = new PriorityQueue<>();

        while (N-- > 0) {
            pq.offer(Double.parseDouble(br.readLine()));
        }

        while (pq.size() != 1) {
            double avg = (pq.poll() + pq.poll()) / 2;
            pq.offer(avg);
        }

        bw.write(pq.poll() + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
