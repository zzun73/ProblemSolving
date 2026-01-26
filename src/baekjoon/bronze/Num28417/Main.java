package baekjoon.bronze.Num28417;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int sum = 0;
            for (int i = 0; i < 2; i++) {
                int X = Integer.parseInt(st.nextToken());
                sum = Math.max(sum, X);
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < 5; i++) {
                int X = Integer.parseInt(st.nextToken());
                pq.add(X);
            }

            sum += pq.poll() + pq.poll();
            answer = Math.max(sum,answer);
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}