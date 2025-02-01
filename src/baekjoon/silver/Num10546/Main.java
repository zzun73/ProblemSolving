package baekjoon.silver.Num10546;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (int i = 1; i < N; i++) {
            String name = br.readLine();
            if (map.containsKey(name)) {
                if (map.get(name) == 1) {
                    map.remove(name);
                } else {
                    map.put(name, map.get(name) - 1);
                }
            }
        }

        for (String val : map.keySet()) {
            bw.write(val);
        }

        br.close();
        bw.close();
    }
}