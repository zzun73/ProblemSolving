package baekjoon.bronze.Num13623;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        if (A == B && A != C) {
            bw.write("C");
        } else if (A == C && A != B) {
            bw.write("B");
        } else if (B == C && A != B) {
            bw.write("A");
        } else {
            bw.write("*");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}