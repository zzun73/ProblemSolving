package baekjoon.gold.Num14677;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static char[] medicine, rule;

    static class Pos {
        int start, end, day, sequence;

        public Pos(int start, int end, int day, int sequence) {
            this.start = start;
            this.end = end;
            this.day = day;
            this.sequence = sequence;
        }
    }

    static int helper() {
        int result = 0;
        boolean[][][] visited = new boolean[medicine.length][medicine.length][3];
        Deque<Pos> deque = new ArrayDeque<>();
        deque.add(new Pos(0, medicine.length - 1, 0, 0));

        while (!deque.isEmpty()) {
            Pos cur = deque.poll();
            int start = cur.start;
            int end = cur.end;
            int day = cur.day;
            int sequence = cur.sequence;

            result = Math.max(day, result);

            if (start > end) {
                continue;
            }

            if (!visited[start][end][sequence]) {
                visited[start][end][sequence] = true;
                if (medicine[start] == rule[sequence]) {
                    deque.add(new Pos(start + 1, end, day + 1, (sequence + 1) % 3));
                }
                if (medicine[end] == rule[sequence]) {
                    deque.add(new Pos(start, end - 1, day + 1, (sequence + 1) % 3));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        medicine = br.readLine().toCharArray();
        rule = new char[]{'B', 'L', 'D'};

        bw.write(String.valueOf(helper()));
        br.close();
        bw.close();
    }

}