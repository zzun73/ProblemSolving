package baekjoon.silver.Num18703;

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
                map.put(key, Math.min(map.getOrDefault(key, value), value));
            }

            List<Integer> list = new ArrayList<>(map.values());
            Collections.sort(list);

            for (int value : list) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}