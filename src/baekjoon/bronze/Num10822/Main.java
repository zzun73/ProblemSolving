package baekjoon.bronze.Num10822;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int answer = 0;

        st = new StringTokenizer(br.readLine(), ",");
        while (st.hasMoreTokens()) {
            answer += Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}