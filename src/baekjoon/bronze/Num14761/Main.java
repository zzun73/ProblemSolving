package baekjoon.bronze.Num14761;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            if (i % X == 0 && i % Y == 0) {
                sb.append("FizzBuzz");
            } else if (i % X == 0) {
                sb.append("Fizz");
            } else if (i % Y == 0) {
                sb.append("Buzz");
            } else {
                sb.append(i);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}