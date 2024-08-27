package baekjoon.bronze.Num02460;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int answer = 0, cur = 0;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int D = Integer.parseInt(st.nextToken());
            int U = Integer.parseInt(st.nextToken());
            cur += U - D;
            answer = Math.max(cur, answer);
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}