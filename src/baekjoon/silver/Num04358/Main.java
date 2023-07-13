package baekjoon.silver.Num04358;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int total = 0;
        HashMap<String, Integer> map = new HashMap<>();
        while (true) {
            String treeName = br.readLine();
            if (treeName == null) {
                break;
            }
            total++;
            map.put(treeName, map.getOrDefault(treeName, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (String treeName : list) {
            double percent = ((double) map.get(treeName) / total) * 100;
            sb.append(treeName).append(" ").append(String.format("%.4f", percent)).append("\n");
        }
        bw.write(sb.toString());


        br.close();
        bw.flush();
        bw.close();
    }
}
