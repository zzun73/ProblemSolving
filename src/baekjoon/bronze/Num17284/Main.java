package baekjoon.bronze.Num17284;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int money = 5000;
        int[] arr = new int[]{500, 800, 1000};

        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            int btn = Integer.parseInt(st.nextToken());
            money -= arr[btn - 1];
        }

        bw.write(String.valueOf(money));

        br.close();
        bw.close();
    }
}