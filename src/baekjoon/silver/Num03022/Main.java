package baekjoon.silver.Num03022;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0, answer = 0;
        Map<String, Integer> map = new HashMap<>();

        while (N-- > 0) {
            String cur = br.readLine();
            if (count - map.getOrDefault(cur, 0) < map.getOrDefault(cur, 0)) {
                answer++;
            }
            count++;
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}