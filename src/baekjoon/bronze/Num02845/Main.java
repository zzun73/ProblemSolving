package baekjoon.bronze.Num02845;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int num = L * P;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 5; i++) {
            bw.write(Integer.parseInt(st.nextToken()) - num + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
