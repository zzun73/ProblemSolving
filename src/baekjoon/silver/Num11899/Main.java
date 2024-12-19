package baekjoon.silver.Num11899;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Character> deque = new ArrayDeque<>();
        int answer = 0;
        for (char ch : br.readLine().toCharArray()) {
            if (ch == ')') {
                if (deque.isEmpty()) {
                    answer++;
                } else {
                    deque.pollLast();
                }
            } else {
                deque.addLast(ch);
            }
        }
        answer += deque.size();
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}