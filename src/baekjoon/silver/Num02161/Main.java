package baekjoon.silver.Num02161;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            System.out.print(queue.peek() + " ");
            queue.poll();
            queue.offer(queue.poll());
        }

        System.out.print(queue.poll());
        br.close();
    }
}
