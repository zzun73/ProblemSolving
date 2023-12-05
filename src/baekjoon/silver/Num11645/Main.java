package baekjoon.silver.Num11645;

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        HashMap<String, Integer> map = new HashMap<>();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            while (N-- > 0) {
                String key = br.readLine();
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            sb.append(map.size()).append("\n");
            map.clear();
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}