package baekjoon.gold.Num02696;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            int N = Integer.parseInt(br.readLine());
            int count = 0;

            sb.append((N + 1) / 2).append("\n");

            for (int i = 0; i < (N + 9) / 10; i++) {
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    int val = Integer.parseInt(st.nextToken());

                    if (maxHeap.isEmpty() || val <= maxHeap.peek()) {
                        maxHeap.offer(val);
                    } else {
                        minHeap.offer(val);
                    }

                    if (maxHeap.size() > minHeap.size() + 1) {
                        minHeap.offer(maxHeap.poll());
                    } else if (minHeap.size() > maxHeap.size()) {
                        maxHeap.offer(minHeap.poll());
                    }

                    if ((maxHeap.size() + minHeap.size()) % 2 == 1) {
                        sb.append(maxHeap.peek()).append(" ");
                        count++;

                        if (count % 10 == 0) {
                            sb.append("\n");
                        }
                    }
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}