package baekjoon.gold.Num05430;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            char[] commands = br.readLine().toCharArray();
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "[],");
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            boolean isError = false;
            boolean isFront = true;
            for (char command : commands) {
                if (command == 'R') {
                    int size = deque.size();
                    isFront = !isFront;
                } else if (command == 'D') {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }

                    if (isFront) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                }
            }

            if (isError) {
                sb.append("error").append("\n");
            } else {
                if (deque.isEmpty()) {
                    sb.append("[]").append("\n");
                    continue;
                }

                sb.append("[");
                if (isFront) {
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollFirst()).append(",");
                    }
                } else {
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollLast()).append(",");
                    }
                }
                sb.setLength(sb.length() - 1);

                sb.append("]").append("\n");
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}