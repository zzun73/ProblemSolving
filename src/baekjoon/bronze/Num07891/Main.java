package baekjoon.bronze.Num07891;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            long answer = Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken());
            bw.write(answer + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
