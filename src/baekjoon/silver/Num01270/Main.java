package baekjoon.silver.Num01270;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {

            Map<Long, Integer> map = new HashMap<>();

            st = new StringTokenizer(br.readLine(), " ");
            int T = Integer.parseInt(st.nextToken());
            for (int i = 0; i < T; i++) {
                long X = Long.parseLong(st.nextToken());
                map.put(X, map.getOrDefault(X, 0) + 1);
            }

            int mid = T / 2;
            long number = -1;
            for (long key : map.keySet()) {
                if (map.get(key) > mid) {
                    number = key;
                    break;
                }
            }

            sb.append(number == -1 ? "SYJKGW" : number).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}