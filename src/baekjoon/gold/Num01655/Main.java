package baekjoon.gold.Num01655;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> fpq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> bpq = new PriorityQueue<>();

        while (N-- > 0) {
            int val = Integer.parseInt(br.readLine());

            if (fpq.size() == bpq.size()) {
                fpq.offer(val);
                if (!bpq.isEmpty() && fpq.peek() > bpq.peek()) {
                    bpq.offer(fpq.poll());
                    fpq.offer(bpq.poll());
                }
            } else {
                bpq.offer(val);
                if (fpq.peek() > bpq.peek()) {
                    bpq.offer(fpq.poll());
                    fpq.offer(bpq.poll());
                }
            }
            sb.append(fpq.peek()).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
