package baekjoon.silver.Num05263;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        while (n-- > 0) {
            int key = Integer.parseInt(br.readLine());
            map.put(key, map.getOrDefault(key, map.getOrDefault(key, 0)) + 1);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) % k != 0) {
                bw.write(String.valueOf(key));
            }
        }

        br.close();
        bw.close();
    }
}