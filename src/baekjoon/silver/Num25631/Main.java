package baekjoon.silver.Num25631;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine(), " ");
        while (N-- > 0) {
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (map.get(a).equals(map.get(b))) {
                return a - b;
            }
            return map.get(b) - map.get(a);
        });

        for (int key : map.keySet()) {
            pq.offer(key);
        }

        bw.write(String.valueOf(map.get(pq.poll())));

        br.close();
        bw.close();
    }
}