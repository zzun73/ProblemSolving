package baekjoon.silver.Num13417;

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
            StringBuilder row = new StringBuilder();
            Deque<Character> deque = new ArrayDeque<>();
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            deque.add(st.nextToken().charAt(0));
            for (int i = 1; i < N; i++) {
                char ch = st.nextToken().charAt(0);
                if (deque.getFirst() < ch) {
                    deque.addLast(ch);
                } else {
                    deque.addFirst(ch);
                }
            }

            for (Character ch : deque) {
                row.append(ch);
            }
            sb.append(row).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}