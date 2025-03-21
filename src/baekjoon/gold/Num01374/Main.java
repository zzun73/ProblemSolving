package baekjoon.gold.Num01374;

import java.io.*;
import java.util.*;

public class Main {
    static class Lecture implements Comparable<Lecture> {
        int start, end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public int compareTo(Lecture o) {
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Lecture> lectures = new ArrayList<>();

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(start, end));
        }
        Collections.sort(lectures);

        int answer = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures.get(0).end);
        for (int i = 1; i < lectures.size(); i++) {
            if (!pq.isEmpty() && pq.peek() <= lectures.get(i).start) {
                pq.poll();
            }
            pq.add(lectures.get(i).end);
            answer = Math.max(answer, pq.size());
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}