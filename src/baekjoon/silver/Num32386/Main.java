package baekjoon.silver.Num32386;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        String answer = null;
        boolean isDuplicate = false;

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            while (t-- > 0) {
                String key = st.nextToken();
                int value = map.getOrDefault(key, 0) + 1;
                map.put(key, value);

                if (value > max) {
                    max = value;
                    answer = key;
                    isDuplicate = false;
                } else if (value == max && !key.equals(answer)) {
                    isDuplicate = true;
                }
            }
        }

        bw.write(isDuplicate ? "-1" : answer);

        bw.close();
        br.close();
    }
}