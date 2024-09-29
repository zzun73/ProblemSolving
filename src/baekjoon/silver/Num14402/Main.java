package baekjoon.silver.Num14402;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        int answer = 0;

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String commute = st.nextToken();

            if (!map.containsKey(name)) {
                map.put(name, map.getOrDefault(name, 0));
            }

            if (commute.equals("+")) {
                map.put(name, map.get(name) + 1);
                continue;
            }

            if (map.get(name) == 0) {
                answer++;
            } else {
                map.replace(name, map.get(name) - 1);
            }
        }

        for (String name : map.keySet()) {
            answer += map.get(name);
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}