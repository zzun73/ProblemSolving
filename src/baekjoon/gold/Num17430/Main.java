package baekjoon.gold.Num17430;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Map<Integer, Integer> mapX = new HashMap<>();
            Map<Integer, Integer> mapY = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            while (N-- > 0) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                mapX.put(x, mapX.getOrDefault(x, 0) + 1);
                mapY.put(y, mapY.getOrDefault(y, 0) + 1);
            }

            Set<Integer> setX = new HashSet<>(mapX.values());
            Set<Integer> setY = new HashSet<>(mapY.values());
            sb.append(setX.size() == 1 && setY.size() == 1 ? "BALANCED" : "NOT BALANCED").append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}