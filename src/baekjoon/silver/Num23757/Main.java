package baekjoon.silver.Num23757;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean answer = true;


        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            pq.add(val);
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int val = Integer.parseInt(st.nextToken());
            if (pq.peek() != null) {
                if (pq.peek() < val) {
                    answer = false;
                    break;
                } else {
                    int res = pq.poll() - val;
                    if (res > 0) {
                        pq.add(res);
                    }
                }
            }
        }

        bw.write(String.valueOf(answer ? 1 : 0));

        br.close();
        bw.flush();
        bw.close();
    }
}