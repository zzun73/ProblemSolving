package baekjoon.gold.Num02812;

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

        Deque<Character> deque = new ArrayDeque<>();
        for (Character ch : br.readLine().toCharArray()) {
            while (!deque.isEmpty() && K > 0 && deque.peekLast() < ch) {
                deque.pollLast();
                K--;
            }
            deque.addLast(ch);
        }

        while (K-- > 0) {
            deque.pollLast();
        }

        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}