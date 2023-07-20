package baekjoon.silver.Num01021;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }
        int answer = 0;
        while (M-- > 0) {
            int findNumber = Integer.parseInt(st.nextToken());
            int idx = deque.indexOf(findNumber);

            if (idx > deque.size() / 2) {
                while (deque.get(0) != findNumber) {
                    deque.offerFirst(deque.pollLast());
                    answer++;
                }
            } else {
                while (deque.get(0) != findNumber) {
                    deque.offerLast(deque.pollFirst());
                    answer++;
                }
            }
            deque.pollFirst();
        }
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
