package baekjoon.silver.Num18115;

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
        Deque<Integer> deque = new ArrayDeque<>();

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = N - 1; i >= 0; i--) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cardNum = 1;
        for (int command : arr) {
            if (command == 1) {
                deque.addFirst(cardNum);
            } else if (command == 2) {
                int top = deque.pollFirst();
                deque.addFirst(cardNum);
                deque.addFirst(top);
            } else if (command == 3) {
                deque.addLast(cardNum);
            }

            cardNum++;
        }

        for (int val : deque) {
            sb.append(val).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}