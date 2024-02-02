package baekjoon.silver.Num25918;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[] str;
    static Deque<Character> deque;

    static int helper() {
        if ((N & 1) == 1) {
            return -1;
        }

        int res = 0;
        deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (deque.isEmpty() || str[i] == deque.peekLast()) {
                deque.addLast(str[i]);
            } else {
                deque.pollLast();
            }
            res = Math.max(res, deque.size());
        }

        return deque.isEmpty() ? res : -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        str = br.readLine().toCharArray();

        bw.write(String.valueOf(helper()));
        br.close();
        bw.close();
    }
}