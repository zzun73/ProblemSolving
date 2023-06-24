package baekjoon.silver.Num02910;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            String input = st.nextToken();
            map.put(input, map.getOrDefault(input, 0) + 1);
        }
        ArrayList<String> keyList = new ArrayList<>(map.keySet());
        keyList.sort((n1, n2) -> {
            int n1Count = map.get(n1);
            int n2Count = map.get(n2);
            if (n1Count == n2Count) {
                return 0;
            }
            return n2Count - n1Count;
        });

        StringBuilder sb = new StringBuilder();
        for (String s : keyList) {
            int cnt = map.get(s);
            while (cnt-- > 0) {
                sb.append(s).append(" ");
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
