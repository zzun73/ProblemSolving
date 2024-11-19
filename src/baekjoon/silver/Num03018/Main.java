package baekjoon.silver.Num03018;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        int key = 1;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        while (E-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            Set<Integer> set = new HashSet<>();

            int K = Integer.parseInt(st.nextToken());
            while (K-- > 0) {
                int X = Integer.parseInt(st.nextToken());
                set.add(X);
            }

            if (set.contains(1)) {
                map.put(key++, set);
            } else {
                for (Integer val : set) {
                    for (Set<Integer> value : map.values()) {
                        if (value.contains(val)) {
                            value.addAll(set);
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (Set<Integer> value : map.values())
                if (value.contains(i)) {
                    count++;
                }

            if (count == map.size()) {
                sb.append(i).append("\n");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}