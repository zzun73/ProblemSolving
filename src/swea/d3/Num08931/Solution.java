package swea.d3.Num08931;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();
            while (N-- > 0) {
                int cur = Integer.parseInt(br.readLine());

                if (cur == 0) {
                    deque.pollLast();
                } else {
                    deque.addLast(cur);
                }
            }

            int answer = 0;
            for (int val : deque) {
                answer += val;
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}