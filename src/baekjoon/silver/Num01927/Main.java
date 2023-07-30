package baekjoon.silver.Num01927;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                int value = 0;
                if (!pq.isEmpty()) {
                    value = pq.poll();
                }
                sb.append(value).append("\n");
            } else {
                pq.offer(input);
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
