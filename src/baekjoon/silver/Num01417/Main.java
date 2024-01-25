package baekjoon.silver.Num01417;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int standard = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        if (!pq.isEmpty()) {
            while (pq.peek() >= standard) {
                pq.add(pq.poll() - 1);
                answer++;
                standard++;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}