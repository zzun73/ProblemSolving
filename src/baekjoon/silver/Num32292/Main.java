package baekjoon.silver.Num32292;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            int curLen = 0;

            while (str.length() != curLen) {
                curLen = str.length();
                str = str.replace("ABB", "BA");
            }
            sb.append(str).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}