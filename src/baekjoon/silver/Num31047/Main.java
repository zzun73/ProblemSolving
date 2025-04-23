package baekjoon.silver.Num31047;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            while (N-- > 0) {
                st = new StringTokenizer(br.readLine(), " ");
                String key = st.nextToken();
                int value = Integer.parseInt(st.nextToken());
                map.put(key, map.getOrDefault(key, 0) + value);
            }

            List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
            entries.sort((e1, e2) -> {
                if (e1.getValue().equals(e2.getValue())) {
                    return e1.getKey().compareTo(e2.getKey());
                } else {
                    return e2.getValue() - e1.getValue();
                }
            });

            sb.append(entries.size()).append("\n");
            for (Map.Entry<String, Integer> entry : entries) {
                sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}