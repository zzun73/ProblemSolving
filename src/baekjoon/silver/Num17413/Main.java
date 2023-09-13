package baekjoon.silver.Num17413;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] words = br.readLine().toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        boolean check = false;

        for (char word : words) {
            if (word == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                check = true;
                sb.append(word);
            } else if (word == '>') {
                sb.append(word);
                check = false;
            } else if (check) {
                sb.append(word);
            } else {
                if (word == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(word);
                } else {
                    stack.push(word);
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}