package baekjoon.bronze.Num21955;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine().trim();
        int mid = str.length() / 2;
        String left = str.substring(0, mid);
        String right = str.substring(mid);

        sb.append(left).append(" ").append(right);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}