package baekjoon.silver.Num01835;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = N; i >= 1; i--) {
            deque.addFirst(i);
            for (int j = 0; j < i; j++) {
                deque.addFirst(deque.pollLast());
            }
        }

        while (!deque.isEmpty()) {
            sb.append(deque.poll()).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}