package baekjoon.silver.Num11576;

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

        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int sum = 0;
        for (int i = N - 1; i >= 0; i--) {
            sum += (Math.pow(A, i) * Integer.parseInt(st.nextToken()));
        }
        Deque<Integer> deque = new ArrayDeque<>();
        while (sum != 0) {
            deque.add(sum % B);
            sum /= B;
        }
        while (!deque.isEmpty()) {
            sb.append(deque.pollLast()).append(" ");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}