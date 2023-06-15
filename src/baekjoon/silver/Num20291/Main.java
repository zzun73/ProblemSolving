package baekjoon.silver.Num20291;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();
            String key = st.nextToken();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        Map<String, Integer> sortedMap = new TreeMap<>(map);
        StringBuilder sb = new StringBuilder();
        for (String s : sortedMap.keySet()) {
            sb.append(s).append(" ").append(sortedMap.get(s)).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
