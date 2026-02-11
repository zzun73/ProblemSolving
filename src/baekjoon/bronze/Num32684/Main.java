package baekjoon.bronze.Num32684;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] point = new int[]{13, 7, 5, 3, 3, 2};
        double first = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < point.length; i++) {
            int X = Integer.parseInt(st.nextToken());
            first += X * point[i];
        }

        st = new StringTokenizer(br.readLine(), " ");
        double second = 1.5;
        for (int i = 0; i < point.length; i++) {
            int X = Integer.parseInt(st.nextToken());
            second += X * point[i];
        }
        bw.write(first <= second ? "ekwoo" : "cocjr0208");

        br.close();
        bw.close();
    }
}