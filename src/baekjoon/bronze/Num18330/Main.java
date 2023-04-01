package baekjoon.bronze.Num18330;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int val = Math.min(k + 60, n);
        int answer = val * 1500 + (n - val) * 3000;

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
