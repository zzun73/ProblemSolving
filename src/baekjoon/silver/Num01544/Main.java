package baekjoon.silver.Num01544;

import java.io.*;
import java.util.HashSet;

public class Main {
    public static void helper(HashSet<String> set, String str) {
        for (String s : set) {
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < str.length(); i++) {
                if (str.equals(sb.toString())) {
                    return;
                } else {
                    sb = sb.append(sb.charAt(0)).deleteCharAt(0);
                }
            }
        }
        set.add(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();

        set.add(br.readLine());
        for (int i = 1; i < N; i++) {
            helper(set, br.readLine());
        }
        bw.write(String.valueOf(set.size()));

        br.close();
        bw.flush();
        bw.close();
    }
}
