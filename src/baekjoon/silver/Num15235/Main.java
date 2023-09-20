package baekjoon.silver.Num15235;

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

        int N = Integer.parseInt(br.readLine());
        Deque<int[]> deque = new ArrayDeque<>();
        int[] answer = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int X = Integer.parseInt(st.nextToken());
            deque.addLast(new int[]{i, X});
        }

        int seq = 0;
        while (!deque.isEmpty()) {
            seq++;
            int[] cur = deque.poll();
            if (--cur[1] == 0) {
                answer[cur[0]] = seq;
            } else {
                deque.addLast(cur);
            }
        }

        for (int val : answer) {
            sb.append(val).append(" ");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}