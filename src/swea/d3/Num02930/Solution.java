package swea.d3.Num02930;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            sb.append("#").append(t).append(" ");
            while (N-- > 0) {
                st = new StringTokenizer(br.readLine(), " ");
                int command = Integer.parseInt(st.nextToken());
                if (command == 1) {
                    int val = Integer.parseInt(st.nextToken());
                    pq.add(val);
                } else {
                    if (pq.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(pq.poll());
                    }
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}