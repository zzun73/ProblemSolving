package baekjoon.gold.Num06198;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        long answer = 0;
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());
            while (!deque.isEmpty() && deque.peekLast() <= cur) {
                deque.pollLast();
            }
            answer += deque.size();
            deque.add(cur);
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}