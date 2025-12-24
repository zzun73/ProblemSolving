package baekjoon.bronze.Num31994;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Seminar implements Comparable<Seminar> {
        String name;
        int count;

        public Seminar(String name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public int compareTo(Seminar o) {
            return o.count - this.count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        List<Seminar> seminars = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String key = st.nextToken();
            int X = Integer.parseInt(st.nextToken());
            seminars.add(new Seminar(key, X));
        }
        Collections.sort(seminars);

        bw.write(String.valueOf(seminars.get(0).name));

        br.close();
        bw.close();
    }
}