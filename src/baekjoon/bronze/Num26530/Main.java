package baekjoon.bronze.Num26530;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            double answer = 0;
            while (N-- > 0) {
                st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                answer += Double.parseDouble(st.nextToken()) * Double.parseDouble(st.nextToken());
            }
            sb.append("$").append(String.format("%.2f\n", answer));
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
