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

        @Override
        public int compareTo(Lecture o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Lecture> lectures = new ArrayList<Lecture>();

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(start, end));
        }
        Collections.sort(lectures);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures.get(0).end);
        for (int i = 1; i < lectures.size(); i++) {
            if (!pq.isEmpty() && pq.peek() <= lectures.get(i).start) {
                pq.poll();
            }
            pq.add(lectures.get(i).end);

        }

        bw.write(String.valueOf(pq.size()));

        br.close();
        bw.close();
    }
}