package baekjoon.silver.Num11507;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        Map<Character, Set<String>> map = new HashMap<>();
        map.put('P', new HashSet<>());
        map.put('K', new HashSet<>());
        map.put('H', new HashSet<>());
        map.put('T', new HashSet<>());

        for (int i = 0; i < str.length(); i += 3) {
            char type = str.charAt(i);
            String number = str.substring(i + 1, i + 3);

            Set<String> set = map.get(type);
            if (!set.add(number)) {
                bw.write("GRESKA");
                bw.close();
                return;
            }
        }

        sb.append(13 - map.get('P').size()).append(" ")
                .append(13 - map.get('K').size()).append(" ")
                .append(13 - map.get('H').size()).append(" ")
                .append(13 - map.get('T').size());

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}