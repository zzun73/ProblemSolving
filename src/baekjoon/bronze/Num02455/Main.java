package baekjoon.bronze.Num02455;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int answer = 0;
        int now = 0;
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());
            now += -out + in;
            answer = Math.max(answer, now);
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}