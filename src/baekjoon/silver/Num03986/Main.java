package baekjoon.silver.Num03986;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        while (N-- > 0) {
            char[] word = br.readLine().toCharArray();
            for (char ch : word) {
                if (!stack.isEmpty() && stack.peek() == ch) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }

            if (stack.isEmpty()) {
                answer++;
            }
            stack.clear();
        }

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
