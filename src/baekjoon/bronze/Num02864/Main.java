package baekjoon.bronze.Num02864;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        String A = st.nextToken();
        String B = st.nextToken();

        int max, min;

        max = Integer.parseInt(A.replace('5', '6')) + Integer.parseInt(B.replace('5', '6'));
        min = Integer.parseInt(A.replace('6', '5')) + Integer.parseInt(B.replace('6', '5'));

        bw.write(min + " " + max);

        br.close();
        bw.flush();
        bw.close();
    }
}
