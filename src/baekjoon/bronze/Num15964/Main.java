package baekjoon.bronze.Num15964;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.println((A + B) * (A - B));
        br.close();
        bw.flush();
        bw.close();
    }
}
