package baekjoon.silver.Num05587;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        TreeSet<Integer> sang = new TreeSet<>();
        TreeSet<Integer> guen = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            sang.add(val);
        }

        for (int i = 1; i <= 2 * N; i++) {
            if (!sang.contains(i)) {
                guen.add(i);
            }
        }


        boolean turnSang = false;
        int prev = 0;
        while (!sang.isEmpty() && !guen.isEmpty()) {
            turnSang = !turnSang;
            if (turnSang) {
                if (prev == 0) {
                    prev = sang.first();
                    sang.remove(prev);
                } else {
                    Integer card = sang.higher(prev);
                    if (card == null) {
                        prev = 0;
                        continue;
                    }
                    prev = card;
                    sang.remove(prev);
                }
            } else {
                if (prev == 0) {
                    prev = guen.first();
                    guen.remove(prev);
                } else {
                    Integer card = guen.higher(prev);
                    if (card == null) {
                        prev = 0;
                        continue;
                    }
                    prev = card;
                    guen.remove(prev);
                }
            }
        }


        sb.append(guen.size()).append("\n").append(sang.size());
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}