package baekjoon.bronze.Num01009;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int val = 1;
            while (b-- > 0) {
                val = (val * a) % 10;
            }

            sb.append(val == 0 ? "10" : val).append("\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

}