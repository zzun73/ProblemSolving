package baekjoon.gold.Num02504;


import java.io.*;
import java.util.*;

public class Main {
    static char[] input;

    static int helper() {
        Deque<String> deque = new ArrayDeque<>();

        for (char ch : input) {
            if (ch == '(' || ch == '[') {
                deque.add(String.valueOf(ch));
            } else {
                int sum = 0;
                while (!deque.isEmpty() && Character.isDigit(deque.peekLast().charAt(0))) {
                    sum += Integer.parseInt(deque.pollLast());
                }

                if (ch == ')') {
                    if (deque.isEmpty() || !deque.pollLast().equals("(")) {
                        return 0;
                    }
                    deque.addLast(String.valueOf(sum == 0 ? 2 : 2 * sum));
                } else if (ch == ']') {
                    if (deque.isEmpty() || !deque.pollLast().equals("[")) {
                        return 0;
                    }
                    deque.addLast(String.valueOf(sum == 0 ? 3 : 3 * sum));
                }
            }
        }

        int result = 0;
        while (!deque.isEmpty()) {
            String s = deque.pollLast();
            if (!Character.isDigit(s.charAt(0))) {
                return 0;
            }
            result += Integer.parseInt(s);
        }

        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input = br.readLine().toCharArray();

        bw.write(String.valueOf(helper()));

        br.close();
        bw.close();
    }
}