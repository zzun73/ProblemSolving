package baekjoon.silver.Num11652;

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        long answer = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        while (N-- > 0) {
            Long key = Long.parseLong(br.readLine());
            map.put(key, map.getOrDefault(key, 0) + 1);

            int curValue = map.get(key);
            if (curValue > max) {
                max = curValue;
                answer = key;
            } else if (curValue == max) {
                answer = Math.min(key, answer);
            }
        }

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
