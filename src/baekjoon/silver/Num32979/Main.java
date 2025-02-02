package baekjoon.silver.Num32979;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()) * 2;
        int T = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine(), " ");
        while (N-- > 0) {
            int cur = Integer.parseInt(st.nextToken());
            deque.addFirst(cur);
        }

        st = new StringTokenizer(br.readLine(), " ");
        while (T-- > 0) {
            int cur = Integer.parseInt(st.nextToken());

            while (--cur > 0) {
                deque.addFirst(deque.pollLast());
            }

            sb.append(deque.peekLast()).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}