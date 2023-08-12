package baekjoon.silver.Num26559;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                String name = st.nextToken();
                int like = Integer.parseInt(st.nextToken());
                map.put(name, like);
            }
            List<String> list = new ArrayList<>(map.keySet());
            list.sort((o1, o2) -> map.get(o2) - map.get(o1));
            for (String str : list) {
                sb.append(str).append(", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
