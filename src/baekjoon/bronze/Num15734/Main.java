package baekjoon.bronze.Num15734;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int sum = L + R + B;
        int temp = B - Math.abs(L - R);

        bw.write(String.valueOf(temp >= 0 ? sum - temp % 2 : sum - Math.abs(temp)));

        br.close();
        bw.close();
    }
}