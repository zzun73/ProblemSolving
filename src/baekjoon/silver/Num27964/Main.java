package baekjoon.silver.Num27964;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        HashSet<String> set = new HashSet<>();
        while (N-- > 0) {
            String str = st.nextToken();
            String temp = str;
            if (temp.length() > 5 && temp.substring(str.length() - 6).equals("Cheese")) {
                set.add(str);
            }
        }
        bw.write(set.size() >= 4 ? "yummy" : "sad");

        br.close();
        bw.flush();
        bw.close();
    }
}