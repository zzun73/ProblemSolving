package baekjoon.bronze.Num31428;

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
        Map<Character, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine(), " ");

        map.put('C', 0);
        map.put('S', 0);
        map.put('I', 0);
        map.put('A', 0);
        for (int i = 0; i < N; i++) {
            char key = st.nextToken().charAt(0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        bw.write(String.valueOf(map.get(br.readLine().charAt(0))));

        br.close();
        bw.close();
    }
}