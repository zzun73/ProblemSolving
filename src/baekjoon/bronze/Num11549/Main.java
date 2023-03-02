package baekjoon.bronze.Num11549;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int answer = 0;
        while (st.hasMoreTokens()) {
            if (T == Integer.parseInt(st.nextToken())) {
                answer++;
            }
        }

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
