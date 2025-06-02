package baekjoon.silver.Num25497;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<Character> dequeL = new ArrayDeque<>();
        Deque<Character> dequeS = new ArrayDeque<>();
        char[] commands = br.readLine().toCharArray();
        int answer = 0;
        for (int i = 0; i < N; i++) {

            if (commands[i] == 'L') {
                dequeL.addLast(commands[i]);
            } else if (commands[i] == 'S') {
                dequeS.addLast(commands[i]);
            } else if (commands[i] == 'R') {
                if (dequeL.isEmpty()) {
                    break;
                }
                dequeL.pollLast();
                answer++;

            } else if (commands[i] == 'K') {
                if (dequeS.isEmpty()) {
                    break;
                }
                dequeS.pollLast();
                answer++;
            } else {
                answer++;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}