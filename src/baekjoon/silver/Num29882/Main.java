package baekjoon.silver.Num29882;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Map<String, Map<String, Integer>> scores = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String problem = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            scores.putIfAbsent(name, new HashMap<>());
            scores.get(name).put(problem, Math.max(scores.get(name).getOrDefault(problem, 0), value));
        }

        Map<String, Integer> map = new HashMap<>();
        for (String name : scores.keySet()) {
            int total = 0;
            for (int v : scores.get(name).values()) {
                total += v;
            }
            map.put(name, total);
        }

        List<Map.Entry<String, Integer>> answer = new ArrayList<>(map.entrySet());
        answer.sort((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<String, Integer> e : answer) {
            sb.append(e.getKey()).append(" ").append(e.getValue()).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}