package baekjoon.gold.Num13549;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int val, time;

    public Node(int val, int time) {
        this.val = val;
        this.time = time;
    }

    @Override
    public int compareTo(Node o) {
        return this.time - o.time;
    }
}
public class Main {
    private static final int INF = Integer.MAX_VALUE;
    static int N, K;
    static int size;
    static PriorityQueue<Node> pq;
    static int[] distance;

    static void helper() {
        Arrays.fill(distance, INF);
        distance[N] = 0;
        pq.add(new Node(N, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (distance[cur.val] < cur.time) {
                continue;
            }
            for (int i = 0; i < 3; i++) {
                int next[] = new int[2];
                switch (i) {
                    case 0:
                        next[0] = cur.val + 1;
                        next[1] = cur.time + 1;
                        break;
                    case 1:
                        next[0] = cur.val - 1;
                        next[1] = cur.time + 1;
                        break;
                    case 2:
                        next[0] = cur.val * 2;
                        next[1] = cur.time;
                        break;
                }

                if (next[0] < 0 || next[0] > size - 1) {
                    continue;
                }

                if (distance[next[0]] > next[1]) {
                    distance[next[0]] = next[1];
                    pq.add(new Node(next[0], next[1]));
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        size = Math.max(N, K) * 2;
        pq = new PriorityQueue<>();
        distance = new int[size];
        helper();
        bw.write(String.valueOf(distance[K]));
        br.close();
        bw.close();
    }
}
