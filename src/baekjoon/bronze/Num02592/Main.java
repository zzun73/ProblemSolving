package baekjoon.bronze.Num02592;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int answer = 0;
        int maxCount = 0;
        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(br.readLine());

            map.put(N, map.getOrDefault(N, 0) + 1);
            sum += N;

            if (maxCount < map.get(N)) {
                maxCount = map.get(N);
                answer = N;
            }
        }

        sb.append(sum / 10).append("\n").append(answer);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}