package baekjoon.gold.Num02608;

import java.io.*;
import java.util.*;

public class Main {
    static Map<String, Integer> map;

    static int convertInteger(String a) {
        int result = 0;

        for (int i = 0; i < a.length(); i++) {
            if (i != a.length() - 1 && (a.charAt(i) == 'I' || a.charAt(i) == 'X' || a.charAt(i) == 'C')) {
                if (map.containsKey(a.substring(i, i + 2))) {
                    result += map.get(a.substring(i, i + 2));
                    i++;
                    continue;
                }
            }
            result += map.get(a.substring(i, i + 1));
        }
        return result;
    }

    static String convertString(int sum) {
        StringBuilder result = new StringBuilder();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));
        for (Map.Entry<String, Integer> entry : list) {
            if (sum / entry.getValue() > 0) {
                result.append(entry.getKey().repeat(sum / entry.getValue()));
                sum %= entry.getValue();
            }
        }

        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        map = new HashMap<>(Map.ofEntries(
                Map.entry("I", 1),
                Map.entry("V", 5),
                Map.entry("X", 10),
                Map.entry("L", 50),
                Map.entry("C", 100),
                Map.entry("D", 500),
                Map.entry("M", 1000),
                Map.entry("IV", 4),
                Map.entry("IX", 9),
                Map.entry("XL", 40),
                Map.entry("XC", 90),
                Map.entry("CD", 400),
                Map.entry("CM", 900)
        ));

        String a = br.readLine();
        String b = br.readLine();

        int aSum = convertInteger(a);
        int bSum = convertInteger(b);

        sb.append(aSum + bSum).append("\n").append(convertString(aSum + bSum));

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}