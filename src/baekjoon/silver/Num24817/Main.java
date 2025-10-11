package baekjoon.silver.Num24817;

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
        int P = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            br.readLine();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String key = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            map.put(key, map.getOrDefault(key, 0) + value);
            if (map.get(key) >= P && !set.contains(key)) {
                set.add(key);
                list.add(key);
            }
        }

        if (!list.isEmpty()) {
            for (String str : list) {
                sb.append(str).append(" ").append("wins!").append("\n");
            }
        } else {
            sb.append("No winner!");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}