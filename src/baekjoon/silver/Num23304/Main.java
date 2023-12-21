package baekjoon.silver.Num23304;

import java.io.*;

public class Main {
    static boolean helper(String s) {
        if (s.length() <= 1) {
            return true;
        }
        int end = s.length() - 1;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(end - i)) {
                return false;
            }
        }
        return helper(s.substring(0, s.length() / 2)) && helper(s.substring(s.length() - s.length() / 2));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(helper(br.readLine()) ? "AKARAKA" : "IPSELENTI");
        br.close();
        bw.flush();
        bw.close();
    }
}