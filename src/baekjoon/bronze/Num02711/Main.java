package baekjoon.bronze.Num02711;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int idx = Integer.parseInt(st.nextToken());
            StringBuilder str = new StringBuilder(st.nextToken());
            str.deleteCharAt(idx - 1);
            sb.append(str).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}