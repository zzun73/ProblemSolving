package swea.d2.Num01204;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            Integer.parseInt(br.readLine());

            HashMap<Integer, Integer> map = new HashMap<>();
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 1000; i++) {
                int key = Integer.parseInt(st.nextToken());
                map.put(key, map.getOrDefault(key, 1) + 1);
            }

            int maxValue = Integer.MIN_VALUE;
            int answer = 0;
            for (int key : map.keySet()) {
                int curVal = map.get(key);
                if (maxValue <= curVal) {
                    maxValue = curVal;
                    answer = Math.max(answer, key);
                }
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}