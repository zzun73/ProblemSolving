package baekjoon.silver.Num26265;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Pair implements Comparable<Pair> {
        String mentor, mentee;

        public Pair(String mentor, String mentee) {
            this.mentor = mentor;
            this.mentee = mentee;
        }

        @Override
        public int compareTo(Pair o) {
            if (mentor.equals(o.mentor)) {
                return mentee.compareTo(o.mentee) * -1;
            }
            return mentor.compareTo(o.mentor);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        List<Pair> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            list.add(new Pair(st.nextToken(), st.nextToken()));
        }

        Collections.sort(list);
        for (Pair pair : list) {
            sb.append(pair.mentor).append(" ").append(pair.mentee).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}