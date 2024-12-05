package baekjoon.silver.Num28464;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");


        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            list.add(val);
        }
        Collections.sort(list);
        Deque<Integer> deque = new ArrayDeque<>(list);

        int idx = 0;
        int answer2 = 0;
        int answer1 = 0;
        while (!deque.isEmpty()) {
            if (++idx % 2 == 0) {
                answer1 += deque.pollFirst();
            } else {
                answer2 += deque.pollLast();
            }
        }

        sb.append(answer1).append(" ").append(answer2);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}