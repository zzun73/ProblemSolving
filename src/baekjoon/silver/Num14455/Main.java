package baekjoon.silver.Num14455;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        map.put("Bessie", 0);
        map.put("Elsie", 0);
        map.put("Daisy", 0);
        map.put("Gertie", 0);
        map.put("Annabelle", 0);
        map.put("Maggie", 0);
        map.put("Henrietta", 0);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String key = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key, 0) + value);
        }
        List<Integer> list = new ArrayList<>(new HashSet<>(map.values()));
        Collections.sort(list);

        if (list.size() < 2) {
            bw.write("Tie");
            bw.close();
            return;
        }

        int targetValue = list.get(1);
        int count = 0;
        for (String str : map.keySet()) {
            if (map.get(str) == targetValue) {
                sb.append(str);
                count++;
            }
        }

        if (count >= 2) {
            bw.write("Tie");
            bw.close();
            return;
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}