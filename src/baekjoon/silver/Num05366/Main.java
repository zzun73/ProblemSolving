package baekjoon.silver.Num05366;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new LinkedHashMap<>();

        while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                break;
            }
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        int sum = 0;
        for (String key : map.keySet()) {
            sb.append(key).append(": ").append(map.get(key)).append("\n");
            sum += map.get(key);
        }
        sb.append("Grand Total: ").append(sum);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}