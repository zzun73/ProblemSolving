package baekjoon.silver.Num12789;

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
        Deque<Integer> store = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            deque.addLast(Integer.parseInt(st.nextToken()));
        }

        int cur = 1;
        while (!deque.isEmpty()) {
            if (deque.peekFirst() == cur) {
                cur++;
                deque.pollFirst();
            } else {
                if (!store.isEmpty() && store.peekLast() == cur) {
                    store.pollLast();
                    cur++;
                } else {
                    store.addLast(deque.pollFirst());
                }
            }
        }
        while (!store.isEmpty()) {
            if (store.peekLast() == cur) {
                cur++;
                store.pollLast();
            } else {
                break;
            }
        }
        bw.write(cur - 1 == N ? "Nice" : "Sad");

        br.close();
        bw.flush();
        bw.close();
    }
}