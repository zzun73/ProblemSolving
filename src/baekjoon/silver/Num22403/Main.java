package baekjoon.silver.Num22403;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        boolean answer = true;
        Deque<String> deque = new ArrayDeque<>();
        while (N-- > 0) {
            String input = br.readLine();
            if (input.equals("A")) {
                deque.add(input);
            } else if (input.equals("Un")) {
                if (!deque.isEmpty()) {
                    deque.poll();
                } else {
                    answer = false;
                    break;
                }
            }
        }
        if (!deque.isEmpty()) {
            answer = false;
        }

        bw.write(answer ? "YES" : "NO");

        br.close();
        bw.close();
    }
}