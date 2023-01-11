package baekjoon.bronze.Num09086;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();
            bw.write(str.charAt(0));
            bw.write(str.charAt(str.length() - 1) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
