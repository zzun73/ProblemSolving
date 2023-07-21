package baekjoon.silver.Num10799;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] ch = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (ch[i - 1] == '(') {
                    answer += (stack.size() - 1);
                } else {
                    answer++;
                }
                stack.pop();
            }
        }
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
