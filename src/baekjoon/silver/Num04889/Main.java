package baekjoon.silver.Num04889;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int answer;
    static char[] input;
    static Deque<Character> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        deque = new ArrayDeque<>();
        for (int t = 1; ; t++) {
            input = br.readLine().toCharArray();
            if (input[0] == '-') {
                break;
            }

            answer = 0;
            deque.clear();
            for (char ch : input) {
                if (!deque.isEmpty() && deque.peekLast() == '{' && ch == '}') {
                    deque.pollLast();
                } else {
                    deque.addLast(ch);
                }
            }
            while (!deque.isEmpty()) {
                char back = deque.pollLast();
                char front = deque.pollLast();
                if (front == back) {
                    answer++;
                } else {
                    answer += 2;
                }
            }

            sb.append(t).append(". ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
