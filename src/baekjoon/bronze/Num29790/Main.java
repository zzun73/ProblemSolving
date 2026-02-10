package baekjoon.bronze.Num29790;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        if (N >= 1000 && (U >= 8000 || L >= 260)) {
            bw.write("Very Good");
        } else if (N >= 1000) {
            bw.write("Good");
        } else {
            bw.write("Bad");
        }

        br.close();
        bw.close();
    }
}