package baekjoon.bronze.Num11034;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String str;
        while ((str = br.readLine()) != null) {
            st = new StringTokenizer(str, " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            int answer = Math.max((B - A), (C - B)) - 1;

            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}