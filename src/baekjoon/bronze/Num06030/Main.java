package baekjoon.bronze.Num06030;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        st = new StringTokenizer(br.readLine(), " ");
        int P = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= P; i++) {
            if (P % i == 0) {
                for (int j = 1; j <= Q; j++) {
                    if (Q % j == 0) {
                        sb.append(i).append(" ").append(j).append("\n");
                    }
                }
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}