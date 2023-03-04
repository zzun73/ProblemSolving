package baekjoon.bronze.Num05717;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int F = Integer.parseInt(st.nextToken());

            if (M + F == 0) {
                break;
            }
            bw.write(M + F + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
