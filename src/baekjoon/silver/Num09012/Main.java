package baekjoon.silver.Num09012;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String yes = "YES\n";
        String no = "NO\n";
        boolean checked;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            checked = false;
            
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == '(') {
                    stack.push(ch);
                } else {
                    if (stack.size() > 0 && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        checked = true;
                        break;
                    }
                }
            }

            if (stack.size() == 0 && !checked) {
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
