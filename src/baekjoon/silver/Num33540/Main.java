package baekjoon.silver.Num33540;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> map = new TreeMap<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int X = Integer.parseInt(st.nextToken());
            map.put(name, map.getOrDefault(name, 0) + X);
        }

        for (String name : map.keySet()) {
            sb.append(name).append(" ").append(map.get(name)).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}