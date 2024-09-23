package baekjoon.silver.Num01755;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = M; i <= N; i++) {
            StringBuilder cur = new StringBuilder();
            if (i >= 10) {
                cur.append(words[i / 10]).append(" ").append(words[i % 10]);
            } else {
                cur.append(words[i]);
            }
            map.put(cur.toString(), i);
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        int count = 0;
        for (String key : list) {
            sb.append(map.get(key)).append(" ");
            if (++count % 10 == 0) {
                sb.append("\n");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}