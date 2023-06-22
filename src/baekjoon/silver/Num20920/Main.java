package baekjoon.silver.Num20920;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String key = br.readLine();
            if (key.length() >= M) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        ArrayList<String> keyList = new ArrayList<>(map.keySet());
        keyList.sort((n1, n2) -> {
            int countN1 = map.get(n1);
            int countN2 = map.get(n2);
            if (countN2 == countN1) {
                if (n1.length() == n2.length()) {
                    return n1.compareTo(n2);
                } else {
                    return n2.length() - n1.length();
                }
            }
            return countN2 - countN1;
        });

        StringBuilder sb = new StringBuilder();
        for (String str : keyList) {
            sb.append(str).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
