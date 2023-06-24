package baekjoon.silver.Num01406;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());

        Stack<Character> lStack = new Stack<>();
        Stack<Character> rStack = new Stack<>();
        for (char c : str.toCharArray()) {
            lStack.push(c);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            switch (command) {
                case "L":
                    if (!lStack.isEmpty()) {
                        rStack.push(lStack.pop());
                    }
                    break;
                case "D":
                    if (!rStack.isEmpty()) {
                        lStack.push(rStack.pop());
                    }
                    break;
                case "B":
                    if (!lStack.isEmpty()) {
                        lStack.pop();
                    }
                    break;
                case "P":
                    char value = st.nextToken().charAt(0);
                    lStack.push(value);
                    break;
            }
        }

        while (!lStack.isEmpty()) {
            rStack.push(lStack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!rStack.isEmpty()) {
            sb.append(rStack.pop());
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}
