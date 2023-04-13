package baekjoon.bronze.Num16673;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i = 1; i <= C; i++) {
            answer += i * K + i * i * P;
        }
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
