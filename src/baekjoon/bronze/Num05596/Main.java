package baekjoon.bronze.Num05596;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int S = 0, T = 0;
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreElements()) {
            S += Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreElements()) {
            T += Integer.parseInt(st.nextToken());
        }

        int answer = Math.max(S, T);
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
