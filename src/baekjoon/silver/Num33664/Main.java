package baekjoon.silver.Num33664;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        long B = Long.parseLong(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Long> map = new HashMap<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            long price = Long.parseLong(st.nextToken());
            map.put(name, price);
        }

        long sum = 0;
        while (M-- > 0) {
            sum += map.get(br.readLine());
        }

        bw.write(sum <= B ? "acceptable" : "unacceptable");

        br.close();
        bw.close();
    }
}