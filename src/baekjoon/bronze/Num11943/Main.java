package baekjoon.bronze.Num11943;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] apple = new int[2];
        int[] orange = new int[2];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            apple[i] = Integer.parseInt(st.nextToken());
            orange[i] = Integer.parseInt(st.nextToken());
        }
        int answer = Math.min(apple[1] + orange[0], apple[0] + orange[1]);
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
