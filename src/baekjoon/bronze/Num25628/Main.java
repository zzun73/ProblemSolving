package baekjoon.bronze.Num25628;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken()) / 2;
        int B = Integer.parseInt(st.nextToken());

        bw.write(Math.min(A, B) + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
