package baekjoon.silver.Num24776;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        Map<String, Integer> map = new HashMap<>();
        while (!(str = br.readLine()).equals("***")) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        int max = 0;
        int count = 0;
        String answer = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int value = entry.getValue();

            if (value > max) {
                max = value;
                answer = entry.getKey();
                count = 1;
            } else if (value == max) {
                count++;
            }
        }

        bw.write(count == 1 ? answer : "Runoff!");

        br.close();
        bw.close();
    }
}