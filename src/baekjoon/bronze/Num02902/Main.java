package baekjoon.bronze.Num02902;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), "-");
        while (st.hasMoreTokens()) {
            sb.append(st.nextToken().charAt(0));
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}