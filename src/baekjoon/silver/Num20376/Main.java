package baekjoon.silver.Num20376;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String str;
        Set<String> set = new HashSet<>();
        while ((str = br.readLine()) != null) {
            st = new StringTokenizer(str, " ");
            st.nextToken();

            StringBuilder cur = new StringBuilder();
            while (st.hasMoreTokens()) {
                cur.append(st.nextToken());
            }
            set.add(cur.toString());
        }

        bw.write(String.valueOf(set.size()));

        br.close();
        bw.close();
    }
}