package baekjoon.silver.Num23305;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            if (map.containsKey(val) && map.get(val) > 0) {
                map.put(val, map.get(val) - 1);
            } else {
                answer++;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}