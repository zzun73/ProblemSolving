package baekjoon.silver.Num10657;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Deque<String> deque = new ArrayDeque<>();
        while (N-- > 0) {
            String str = br.readLine();
            if (str.equals("READ")) {
                sb.append(deque.pollFirst()).append("\n");
            } else {
                deque.addFirst(str);
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}