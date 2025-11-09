package baekjoon.silver.Num22076;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        List<Integer> answer = new ArrayList<>();
        Set<Integer> used = new HashSet<>();
        for (int key : map.keySet()) {
            if (answer.size() < K) {
                answer.add(key);
                used.add(key);
            }
        }
        if (answer.size() < K) {
            int remain = K - answer.size();

            for (int key : map.keySet()) {
                if (!used.contains(key)|| map.get(key) >1) {
                    int size = Math.min(map.get(key)-1, remain);
                    remain -= size;

                    while (size-- > 0) {
                        answer.add(key);
                    }
                }
                if (remain == 0) {
                    break;
                }
            }
        }

        for (int val : answer) {
            sb.append(val).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}