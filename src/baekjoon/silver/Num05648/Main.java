package baekjoon.silver.Num05648;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        List<Long> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());

        while (N > 0) {
            while (st.hasMoreTokens()) {
                StringBuilder cur = new StringBuilder(st.nextToken());
                list.add(Long.parseLong(cur.reverse().toString()));
                N--;
            }
            if (N == 0) {
                break;
            }
            st = new StringTokenizer(br.readLine(), " ");
        }

        Collections.sort(list);

        for (long val : list) {
            sb.append(val).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}