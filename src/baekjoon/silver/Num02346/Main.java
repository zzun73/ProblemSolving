package baekjoon.silver.Num02346;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<int[]> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int X = Integer.parseInt(st.nextToken());
            deque.addLast(new int[]{i + 1, X});
        }

        while (deque.size() > 1) {
            int[] cur = deque.pollFirst();
            sb.append(cur[0]).append(" ");
            if (cur[1] > 0) {
                for (int i = 1; i < cur[1]; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for (int i = cur[1]; i != 0; i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }
        sb.append(deque.peekFirst()[0]);
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}