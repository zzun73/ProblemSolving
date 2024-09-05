package baekjoon.silver.Num10527;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> mapA = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String key = br.readLine();
            mapA.put(key, mapA.getOrDefault(key, 0) + 1);
        }

        Map<String, Integer> mapB = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String key = br.readLine();
            mapB.put(key, mapB.getOrDefault(key, 0) + 1);
        }

        int answer = 0;
        for (String key : mapA.keySet()) {
            if (mapB.containsKey(key)) {
                answer += Math.min(mapA.get(key), mapB.get(key));
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}