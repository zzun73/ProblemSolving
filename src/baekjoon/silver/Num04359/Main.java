package baekjoon.silver.Num04359;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int P = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        Map<Integer, TreeSet<Integer>> map = new HashMap<>();

        for (int i = 1; i <= P; i++) {
            map.put(i, new TreeSet<>());
        }

        String input;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input, " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            map.get(i).add(j);
        }

        Set<TreeSet<Integer>> set = new HashSet<>(map.values());

        bw.write(String.valueOf(set.size()));

        br.close();
        bw.close();
    }
}