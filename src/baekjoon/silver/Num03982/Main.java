package baekjoon.silver.Num03982;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            HashMap<String, Integer> map = new HashMap<>();
            int game = 16;

            while (game-- > 0) {
                st = new StringTokenizer(br.readLine(), " ");

                String teamA = st.nextToken();
                String teamB = st.nextToken();
                int scoreA = Integer.parseInt(st.nextToken());
                int scoreB = Integer.parseInt(st.nextToken());

                if (scoreA > scoreB) {
                    map.put(teamA, map.getOrDefault(teamA, 0) + 1);
                } else if (scoreA < scoreB) {
                    map.put(teamB, map.getOrDefault(teamB, 0) + 1);
                }
            }

            int maxScore = 0;
            String answer = null;
            for (String key : map.keySet()) {
                if (map.get(key) > maxScore) {
                    maxScore = map.get(key);
                    answer = key;
                }
            }
            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}