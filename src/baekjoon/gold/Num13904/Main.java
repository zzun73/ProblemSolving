package baekjoon.gold.Num13904;

import java.io.*;
import java.util.*;

class Problem implements Comparable<Problem> {
    int d, w;

    public Problem(int d, int w) {
        this.d = d;
        this.w = w;
    }

    @Override
    public int compareTo(Problem o) {
        return o.w - this.w;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        boolean[] visited = new boolean[1001];
        PriorityQueue<Problem> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Problem(d, w));
        }

        while (!pq.isEmpty()) {
            Problem cur = pq.poll();
            if (!visited[cur.d]) {
                visited[cur.d] = true;
                answer += cur.w;
                continue;
            }

            while (--cur.d >= 1) {
                if (!visited[cur.d]) {
                    visited[cur.d] = true;
                    answer += cur.w;
                    break;
                }
            }

        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}