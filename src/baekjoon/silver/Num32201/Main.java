package baekjoon.silver.Num32201;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new LinkedHashMap<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            int X = Integer.parseInt(st.nextToken());
            map.put(X, i);
        }

        st = new StringTokenizer(br.readLine(), " ");
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            int X = Integer.parseInt(st.nextToken());
            map.put(X, map.get(X) - i);
            max = Math.max(max, map.get(X));
        }

        for (Integer val : map.keySet()) {
            if(map.get(val) == max) {
                sb.append(val).append(" ");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}