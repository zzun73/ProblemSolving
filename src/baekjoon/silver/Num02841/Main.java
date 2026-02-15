package baekjoon.silver.Num02841;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Deque<Integer>[] deque = new ArrayDeque[7];
        for (int i = 1; i <= deque.length; i++) {
            deque[i] = new ArrayDeque<>();
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int line = Integer.parseInt(st.nextToken());
            int fret = Integer.parseInt(st.nextToken());

            while (!deque[line].isEmpty() && deque[line].peekLast() > fret) {
                deque[line].pollLast();
                answer++;
            }

            if (deque[line].isEmpty() || deque[line].peekLast() < fret) {
                deque[line].addLast(fret);
                answer++;
            }
        }
            bw.write(String.valueOf(answer));

            br.close();
            bw.close();

    }
}