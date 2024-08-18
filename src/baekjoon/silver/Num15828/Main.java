package baekjoon.silver.Num15828;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        while (true) {
            int cur = Integer.parseInt(br.readLine());
            if (cur == -1) {
                break;
            }

            if (cur == 0) {
                deque.poll();
            } else {
                if (deque.size() == N) {
                    continue;
                }
                deque.add(cur);
            }
        }
        if (deque.isEmpty()) {
            bw.write("empty");
        } else {
            while (!deque.isEmpty()) {
                sb.append(deque.poll()).append(" ");
            }
        }


        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
