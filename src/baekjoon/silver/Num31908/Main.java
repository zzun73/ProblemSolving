package baekjoon.silver.Num31908;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<String, List<String>> map = new HashMap<>();
        int count = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String ring = st.nextToken();

            if (ring.equals("-")) {
                continue;
            }
            if (!map.containsKey(ring)) {
                map.put(ring, new ArrayList<>());
            }
            map.get(ring).add(name);
        }

        for (String key : map.keySet()) {
            if (map.get(key).size() == 2) {
                for (String name : map.get(key)) {
                    sb.append(name).append(" ");
                }
                sb.append("\n");
                count++;
            }
        }
        sb.insert(0, count + "\n");

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}