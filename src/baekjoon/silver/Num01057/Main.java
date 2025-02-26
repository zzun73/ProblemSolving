package baekjoon.silver.Num01057;

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
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        boolean isEnd = false;
        int answer = 0;
        while (N > 1 && !isEnd) {
            for (int i = 0; i < N / 2; i++) {
                int n1 = deque.poll();
                int n2 = deque.poll();

                if ((n1 == A && n2 == B) || (n1 == B && n2 == A)) {
                    isEnd = true;
                    break;
                }
                if (n2 == A || n2 == B) {
                    deque.add(n2);
                } else {
                    deque.add(n1);
                }
            }
            if ((N & 1) == 0) {
                N /= 2;
            } else {
                deque.add(deque.poll());
                N = (N / 2) + 1;
            }
            answer++;
        }
        bw.write(String.valueOf(isEnd ? answer : -1));

        br.close();
        bw.close();
    }
}