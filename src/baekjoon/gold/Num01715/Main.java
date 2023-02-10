package baekjoon.gold.Num01715;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            priorityQueue.offer(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while (priorityQueue.size() > 1) {
            int sum = priorityQueue.poll() + priorityQueue.poll();
            answer += sum;
            priorityQueue.offer(sum);
        }

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
