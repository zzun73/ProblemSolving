package baekjoon.gold.Num25381;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> A = new ArrayDeque<>();
        Deque<Integer> B = new ArrayDeque<>();
        Deque<Integer> C = new ArrayDeque<>();

        int answer = 0;
        int idx = 0;
        for (char ch : br.readLine().toCharArray()) {
            if (ch == 'A') {
                A.addLast(idx);
            } else if (ch == 'B') {
                B.addLast(idx);
            } else if (ch == 'C') {
                C.addLast(idx);
            }
            idx++;
        }

        while (!B.isEmpty() && !C.isEmpty()) {
            if (B.peekFirst() < C.peekFirst()) {
                B.pollFirst();
                answer++;
            }
            C.pollFirst();
        }

        while (!A.isEmpty() && !B.isEmpty()) {
            if (A.peekFirst() < B.peekFirst()) {
                A.pollFirst();
                answer++;
            }
            B.pollFirst();
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
