package baekjoon.silver.Num04949;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String yes = "yes\n";
        String no = "no\n";
        boolean checked;
        while (true) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            checked = false;
            if (str.charAt(0) == '.') {
                break;
            }

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (stack.size() > 0 && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        checked = true;
                        break;
                    }
                } else if (ch == ']') {
                    if (stack.size() > 0 && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        checked = true;
                        break;
                    }
                }
            }

            if (stack.empty() && !checked) {
                bw.write(yes);
            } else {
                bw.write(no);
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
