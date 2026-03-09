package baekjoon.silver.Num10489;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine(), " ");
        while (N-- > 0) {
            int X = Integer.parseInt(st.nextToken());
            if (!deque.isEmpty() && ((deque.peekLast() + X) & 1) == 0) {
                deque.pollLast();
            } else {
                deque.addLast(X);
            }
        }

        bw.write(String.valueOf(deque.size()));

        br.close();
        bw.close();
    }
}