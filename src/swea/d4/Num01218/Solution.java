package swea.d4.Num01218;

import java.io.*;
import java.util.*;

public class Solution {
    private static final int SUCCESS = 1;
    private static final int FAIL = 0;
    static StringBuilder sb;
    static Deque<Character> deque;

    static boolean isOpen(char ch) {
        return (ch == '[' || ch == '{' || ch == '(' || ch == '<');
    }

    static boolean isPair(char o, char e) {
        return ((o == '[' && e == ']') || (o == '{' && e == '}') || (o == '(' && e == ')') || (o == '<' && e == '>'));
    }

    static void helper(char[] input) {
        deque = new ArrayDeque<>();
        for (int i = 0; i < input.length; i++) {
            char cur = input[i];
            // 여는 괄호일 경우 삽입
            if (isOpen(cur)) {
                deque.addLast(cur);
                continue;
            }
            if (!deque.isEmpty()) {
                if (!isPair(deque.pollLast(), cur)) {
                    sb.append(FAIL);
                    return;
                }
            } else {
                sb.append(FAIL);
                return;
            }
        }
        sb.append(deque.isEmpty() ? SUCCESS : FAIL);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            int len = Integer.parseInt(br.readLine());
            sb.append("#").append(t).append(" ");
            helper(br.readLine().toCharArray());
            sb.append("\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}