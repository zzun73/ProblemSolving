package baekjoon.silver.Num10828;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Stack<Integer> stack = new Stack<>();
        int X;
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            switch (command) {
                case "push":
                    X = Integer.parseInt(st.nextToken());
                    stack.push(X);
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        X = -1;
                    } else {
                        X = stack.pop();
                    }
                    bw.write(X + "\n");
                    break;
                case "size":
                    bw.write(stack.size() + "\n");
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        X = 1;
                    } else {
                        X = 0;
                    }
                    bw.write(X + "\n");
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        X = -1;
                    } else {
                        X = stack.peek();
                    }
                    bw.write(X + "\n");
                    break;
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
