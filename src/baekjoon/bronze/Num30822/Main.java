package baekjoon.bronze.Num30822;

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        HashMap<Character, Integer> map = new HashMap<>();

        map.put('u', 0);
        map.put('o', 0);
        map.put('s', 0);
        map.put('p', 0);
        map.put('c', 0);

        for (char ch : br.readLine().toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            }
        }

        int answer = Integer.MAX_VALUE;
        for (Character ch : map.keySet()) {
            answer = Math.min(map.get(ch), answer);
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}