package baekjoon.silver.Num09612;

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        String answer = "";
        for (String str : map.keySet()) {
            int val = map.get(str);
            if (val > max) {
                max = val;
                answer = str;
            } else if (val == max) {
                if (str.compareTo(answer) > 0) {
                    answer = str;
                }
            }
        }
        bw.write(String.format("%s %d", answer, max));
        br.close();
        bw.flush();
        bw.close();
    }
}
