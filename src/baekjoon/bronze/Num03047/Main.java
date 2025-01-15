package baekjoon.bronze.Num03047;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 3; i++) {
            int a = Integer.parseInt(st.nextToken());
            list.add(a);
        }
        Collections.sort(list);

        Map<Character, Integer> map = new HashMap<>();
        for (char i = 'A'; i <= 'C'; i++) {
            map.put(i, list.get(i - 'A'));
        }

        for (char c : br.readLine().toCharArray()) {
            sb.append(map.get(c)).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}