package baekjoon.gold.Num01781;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Problem implements Comparable<Problem> {
        int deadline, count;

        public Problem(int deadline, int count) {
            this.deadline = deadline;
            this.count = count;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.deadline == o.deadline) {
                return o.count - this.count;
            }
            return this.deadline - o.deadline;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Problem> problems = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            problems.add(new Problem(d, p));
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        while (!problems.isEmpty()) {
            Problem problem = problems.poll();

            pq.add(problem.count);
            answer += problem.count;

            if (pq.size() > problem.deadline) {
                answer -= pq.poll();
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}