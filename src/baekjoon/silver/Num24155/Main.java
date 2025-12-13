package baekjoon.silver.Num24155;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];
        int[] count = new int[101];

        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(br.readLine());
            count[score[i]]++;
        }

        int[] rank = new int[101];
        int curRank = 1;
        for (int s = 100; s >= 0; s--) {
            if (count[s] > 0) {
                rank[s] = curRank;
                curRank += count[s];
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(rank[score[i]]).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
