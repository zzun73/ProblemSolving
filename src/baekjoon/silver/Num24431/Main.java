package baekjoon.silver.Num24431;

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

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int F = Integer.parseInt(st.nextToken());

            Map<String, Integer> map = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            while (n-- > 0) {
                String word = st.nextToken().substring(L - F);
                map.put(word, map.getOrDefault(word, 0) + 1);
            }

            int answer = 0;
            for (int value : map.values()) {
                answer += value / 2;
            }

            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}