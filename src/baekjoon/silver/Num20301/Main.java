package baekjoon.silver.Num20301;

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

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        int count = 0;
        boolean isRight = true;

        while (!deque.isEmpty()) {
            if (isRight) {
                for (int i = 0; i < K - 1; i++) {
                    deque.offerLast(deque.pollFirst());
                }
                sb.append(deque.pollFirst()).append("\n");
            } else {
                for (int i = 0; i < K - 1; i++) {
                    deque.offerFirst(deque.pollLast());
                }
                sb.append(deque.pollLast()).append("\n");
            }
            count++;

            if (count == M) {
                isRight = !isRight;
                count = 0;
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}