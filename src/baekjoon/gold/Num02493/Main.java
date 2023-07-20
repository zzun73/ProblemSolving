package baekjoon.gold.Num02493;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{Integer.parseInt(st.nextToken()), 1});
        sb.append(0).append(" ");
        for (int i = 1; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            int idx = i + 1;

            while (!stack.isEmpty()) {

                if (stack.peek()[0] > cur) {
                    sb.append(stack.peek()[1]).append(" ");
                    stack.push(new int[]{cur, idx});
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                sb.append(0).append(" ");
                stack.push(new int[]{cur, idx});
            }

        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}
