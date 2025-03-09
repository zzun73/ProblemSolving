package baekjoon.bronze.Num02476;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int sum;
            if (a == b && b == c) {
                sum = 10000 + a * 1000;
            } else if (a == b) {
                sum = 1000 + a * 100;
            } else if (b == c) {
                sum = 1000 + b * 100;
            } else if (c == a) {
                sum = 1000 + c * 100;
            } else {
                sum = Math.max(a, Math.max(b, c)) * 100;
            }
            answer = Math.max(answer, sum);
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}