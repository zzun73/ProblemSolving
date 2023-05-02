package baekjoon.bronze.Num11023;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int answer = 0;
        while (st.hasMoreTokens()) {
            answer += Integer.parseInt(st.nextToken());
        }
        bw.write(answer+"");

        br.close();
        bw.flush();
        bw.close();
    }
}
