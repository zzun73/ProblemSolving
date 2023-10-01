package baekjoon.silver.Num14730;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int C = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            answer += C * K ;
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}