package baekjoon.silver.Num14769;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Cup implements Comparable<Cup> {
        String name;
        int size;

        public Cup(String name, int size) {
            this.name = name;
            this.size = size;
        }

        @Override
        public int compareTo(Cup o) {
            return this.size - o.size;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Cup[] cups = new Cup[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String a = st.nextToken();
            String b = st.nextToken();
            if (a.charAt(0) - '0' >= 0 && a.charAt(0) - '0' <= 9) {
                cups[i] = new Cup(b, Integer.parseInt(a)/2);
            } else {
                cups[i] = new Cup(a, Integer.parseInt(b));
            }
        }
        Arrays.sort(cups);

        for (Cup cup : cups) {
            sb.append(cup.name).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}