package baekjoon.silver.Num05104;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> scoreMap = new HashMap<>();

        scoreMap.put("TT", 75);
        scoreMap.put("TX", 50);
        scoreMap.put("PR", 80);
        scoreMap.put("RT", 30);
        scoreMap.put("AP", 25);
        scoreMap.put("PX", 60);

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int week = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            if (week == 0 && N == 0) {
                break;
            }

            Map<String, Integer> peopleMap = new LinkedHashMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                String key = st.nextToken();
                int value = scoreMap.get(st.nextToken());

                peopleMap.put(key, peopleMap.getOrDefault(key, 0) + value);
            }
            List<String> peopleList = new ArrayList<>();

            for (String key : peopleMap.keySet()) {
                if (peopleMap.get(key) >= 100) {
                    peopleList.add(key);
                }
            }
            sb.append("Week ").append(week).append(" ");
            if (peopleList.isEmpty()) {
                sb.append("No phones confiscated");
            } else {
                sb.append(String.join(",", peopleList));
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}