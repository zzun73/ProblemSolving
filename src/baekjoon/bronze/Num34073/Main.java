package baekjoon.bronze.Num34073;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        while (N-- > 0) {
            sb.append( st.nextToken()).append("DORO").append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}