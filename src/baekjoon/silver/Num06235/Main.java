package baekjoon.silver.Num06235;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int number, period, nextTime;

        public Node(int number, int period) {
            this.number = number;
            this.period = period;
            this.nextTime = period;
        }

        @Override
        public int compareTo(Node o) {
            if (this.nextTime == o.nextTime) {
                return this.number - o.number;
            }
            return this.nextTime - o.nextTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Node> pq = new PriorityQueue<>();
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            if (command.equals("#")) {
                break;
            }
            int number = Integer.parseInt(st.nextToken());
            int period = Integer.parseInt(st.nextToken());
            pq.add(new Node(number, period));
        }

        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            Node cur = pq.poll();
            sb.append(cur.number).append("\n");
            cur.nextTime += cur.period;
            pq.offer(cur);
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}