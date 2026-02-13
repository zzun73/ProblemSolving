package baekjoon.gold.Num02457;

import java.io.*;
import java.util.*;

public class Main {
    static int[] day = new int[]{0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

    static class Range implements Comparable<Range> {
        int start, end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Range o) {
            if (this.start == o.start) {
                return Integer.compare(o.end, this.end);
            }
            return Integer.compare(this.start, o.start);
        }

    }

    static int monthToDay(int m, int d) {
        return day[m] + d;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Range[] ranges = new Range[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            ranges[i] = new Range(monthToDay(a, b), monthToDay(c, d));
        }
        Arrays.sort(ranges);

        int targetStart = monthToDay(3, 1);
        int targetEnd = monthToDay(12, 1);
        int cur = targetStart;
        int answer = 0;
        int i = 0;
        while (cur < targetEnd && i < N) {
            int maxEnd = cur;

            while (i < N && ranges[i].start <= cur) {
                maxEnd = Math.max(maxEnd, ranges[i].end);
                i++;
            }

            if (maxEnd == cur) {
                break;
            }

            cur = maxEnd;
            answer++;
        }

        bw.write(String.valueOf(cur >= targetEnd ? answer : 0));

        br.close();
        bw.close();
    }
}