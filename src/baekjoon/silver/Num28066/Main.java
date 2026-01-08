package baekjoon.silver.Num28066;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        while (deque.size() >= K) {
            deque.addLast(deque.pollFirst());
            int count = K - 1;
            while (count-- > 0) {
                deque.pollFirst();
            }
        }

        bw.write(String.valueOf(deque.pollFirst()));

        br.close();
        bw.close();
    }
}