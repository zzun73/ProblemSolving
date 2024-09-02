package baekjoon.silver.Num05349;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        HashMap<String, Integer> map = new HashMap<>();
        while (true) {
            String str = br.readLine();
            if (str.equals("000-00-0000")) {
                break;
            }

            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());
        list.sort(String::compareTo);
        for (String key : list) {
            if (map.get(key) != 1) {
                sb.append(key).append("\n");
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}