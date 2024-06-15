package baekjoon.bronze.Num11772;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int temp = 0;
        int result = 0;

        for (int i = 0; i < N; i++) {
            temp = Integer.parseInt(br.readLine());
            result += (int) Math.pow((temp / 10), (temp % 10));
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}