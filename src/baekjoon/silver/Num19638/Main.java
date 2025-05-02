package baekjoon.silver.Num19638;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (N-- > 0) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        while (T-- > 0) {
            if ((pq.peek() < H) || (pq.peek() == 1)) {
                break;
            }
            pq.add(pq.poll() / 2);
            count++;
        }

        if (pq.peek() < H) {
            sb.append("YES").append("\n").append(count);
        } else {
            sb.append("NO").append("\n").append(pq.peek());
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}