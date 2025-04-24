package baekjoon.silver.Num14670;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            map.put(key, value);
        }

        int R = Integer.parseInt(br.readLine());
        while (R-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int L = Integer.parseInt(st.nextToken());
            boolean flag = true;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < L; i++) {
                int val = Integer.parseInt(st.nextToken());
                if (!map.containsKey(val)) {
                    flag = false;
                } else {
                    list.add(map.get(val));
                }
            }

            if (flag) {
                for (Integer val : list) {
                    sb.append(val).append(" ");
                }
            } else {
                sb.append("YOU DIED");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}