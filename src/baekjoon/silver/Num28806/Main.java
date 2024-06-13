package baekjoon.silver.Num28806;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();

        int num = 0;
        while (++num <= N) {
            deque.addLast(num);
        }

        while (deque.size() >= K) {
            deque.addLast(deque.pollFirst());
            int size = K - 1;
            while (size-- > 0) {
                deque.pollFirst();
            }
        }
        bw.write(String.valueOf(deque.pollFirst()));

        br.close();
        bw.close();
    }
}