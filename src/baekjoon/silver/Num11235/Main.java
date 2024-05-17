package baekjoon.silver.Num11235;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String key = br.readLine();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int max = Collections.max(map.values());
        List<String> winners = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s) == max) {
                winners.add(s);
            }
        }

        Collections.sort(winners);
        for (String winner : winners) {
            sb.append(winner).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}