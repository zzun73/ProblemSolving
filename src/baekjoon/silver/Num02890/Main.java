package baekjoon.silver.Num02890;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        String[] kayak = new String[R];
        for (int i = 0; i < R; i++) {
            kayak[i] = br.readLine();
        }

        int rank = 1;
        int[] ranks = new int[R + 1];
        boolean[] visited = new boolean[10];

        for (int i = C - 1; i > 0; i--) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < R; j++) {

                int idx = kayak[j].charAt(i) - '0';
                if (idx < 0 || idx > 10 || visited[idx]) {
                    continue;
                }

                visited[idx] = true;
                list.add(idx);
            }
            for (int val : list) {
                ranks[val] = rank;
            }
            if (!list.isEmpty()) {
                rank++;
            }
        }

        for (int i = 1; i < 10; i++) {
            sb.append(ranks[i]).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}