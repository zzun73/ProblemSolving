package baekjoon.bronze.Num02506;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int val = 1;
        st = new StringTokenizer(br.readLine(), " ");
        while (N-- > 0) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur == 1) {
                answer += val;
                val++;
            } else {
                val = 1;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}