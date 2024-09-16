package baekjoon.silver.Num28446;

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

        int M = Integer.parseInt(br.readLine());
        int x;
        long w;
        Map<Long, Integer> map = new HashMap<>();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) {
                x = Integer.parseInt(st.nextToken());
                w = Long.parseLong(st.nextToken());
                map.put(w, x);
            } else if (command == 2) {
                w = Long.parseLong(st.nextToken());
                sb.append(map.get(w)).append("\n");
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}