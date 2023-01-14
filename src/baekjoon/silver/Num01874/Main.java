package baekjoon.silver.Num01874;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int pos = 0;
        Stack<Integer> stack = new Stack<>();

        while (N-- > 0) {
            int value = Integer.parseInt(br.readLine());

            if (value > pos) {
                for (int i = pos + 1; i <= value; i++) {
                    stack.push(i);
                    sb.append("+").append("\n");
                }
                pos = value;
            } else if (stack.peek() != value) {
                sb.setLength(0);
                sb.append("NO");
                break;
            }

            stack.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
