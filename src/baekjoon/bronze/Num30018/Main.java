package baekjoon.bronze.Num30018;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer stA = new StringTokenizer(br.readLine());
        StringTokenizer stB = new StringTokenizer(br.readLine());

        long answer = 0;
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(stA.nextToken());
            int b = Integer.parseInt(stB.nextToken());
            if (a > b) {
                answer += (a - b);
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}