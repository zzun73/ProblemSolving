package baekjoon.silver.Num10866;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Deque<Integer> deque = new LinkedList<>();
        int X;
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            switch (command) {
                case "push_front":
                    X = Integer.parseInt(st.nextToken());
                    deque.offerFirst(X);
                    break;
                case "push_back":
                    X = Integer.parseInt(st.nextToken());
                    deque.offerLast(X);
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        X = -1;
                    } else {
                        X = deque.pollFirst();
                    }
                    bw.write(X + "\n");
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        X = -1;
                    } else {
                        X = deque.pollLast();
                    }
                    bw.write(X + "\n");
                    break;
                case "size":
                    bw.write(deque.size() + "\n");
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        X = 1;
                    } else {
                        X = 0;
                    }
                    bw.write(X + "\n");
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        X = -1;
                    } else {
                        X = deque.peekFirst();
                    }
                    bw.write(X + "\n");
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        X = -1;
                    } else {
                        X = deque.peekLast();
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
