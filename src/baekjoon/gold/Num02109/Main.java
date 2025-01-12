package baekjoon.gold.Num02109;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Place implements Comparable<Place> {

        int price, day;

        public Place(int price, int day) {
            this.price = price;
            this.day = day;
        }

        @Override
        public int compareTo(Place o) {
            if (this.price == o.price) {
                return o.day - this.day;
            }
            return o.price - this.price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Place> pq = new PriorityQueue<>();

        int maxDay = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pq.add(new Place(p, d));
            maxDay = Math.max(maxDay, d);
        }

        int answer = 0;
        boolean[] visited = new boolean[maxDay + 1];

        while (!pq.isEmpty()) {
            Place next = pq.poll();

            for (int day = next.day; day > 0; day--) {
                if (!visited[day]) {
                    visited[day] = true;
                    answer += next.price;
                    break;
                }
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}