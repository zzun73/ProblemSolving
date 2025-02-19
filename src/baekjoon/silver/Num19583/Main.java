package baekjoon.silver.Num19583;

import java.io.*;
import java.util.*;

public class Main {

    static int convertToInt(String str) {
        String[] split = str.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int s = convertToInt(st.nextToken());
        int e = convertToInt(st.nextToken());
        int q = convertToInt(st.nextToken());

        String input;
        Set<String> in = new HashSet<>();
        Set<String> out = new HashSet<>();
        Set<String> all = new HashSet<>();
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input, " ");
            int time = convertToInt(st.nextToken());
            String key = st.nextToken();
            all.add(key);

            if (time <= s) {
                in.add(key);
            }

            if (time >= e && time <= q) {
                out.add(key);
            }
        }

        int answer = 0;
        for (String name : all) {
            if(in.contains(name)&& out.contains(name)) {
                answer++;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}