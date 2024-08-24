package baekjoon.silver.Num01822;

import java.io.*;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<Integer> set = new TreeSet<>();

        st = new StringTokenizer(br.readLine(), " ");
        while (N-- > 0) {
            int val = Integer.parseInt(st.nextToken());
            set.add(val);
        }

        st = new StringTokenizer(br.readLine(), " ");
        while (M-- > 0) {
            int val = Integer.parseInt(st.nextToken());
            set.remove(val);
        }

        if (set.isEmpty()) {
            sb.append(0);
        } else {
            sb.append(set.size()).append("\n");
            for (Integer val : set) {
                sb.append(val).append(" ");
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}