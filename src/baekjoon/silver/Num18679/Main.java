package baekjoon.silver.Num18679;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<String, String> map = new HashMap<>();

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " = ");
            String key = st.nextToken();
            String value = st.nextToken();
            map.put(key, value);
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int size = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                sb.append(map.get(st.nextToken())).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}