package baekjoon.silver.Num09872;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        while (N-- > 0) {
            char[] cow = br.readLine().toCharArray();
            Arrays.sort(cow);
            String key = String.valueOf(cow);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int answer = 0;
        for (String key : map.keySet()) {
            answer = Math.max(answer, map.get(key));
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}