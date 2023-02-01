package baekjoon.silver.Num01302;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> answer = new ArrayList<>();

        while (T-- > 0) {
            String line = br.readLine();
            map.put(line, map.getOrDefault(line, 0) + 1);
        }

        int max = Collections.max(map.values());
        for (String key : map.keySet()) {
            if (max == map.get(key)) {
                answer.add(key);
            }
        }

        Collections.sort(answer);
        bw.write(answer.get(0));

        br.close();
        bw.flush();
        bw.close();
    }
}
