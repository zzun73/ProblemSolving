package baekjoon.bronze.Num20833;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer += Math.pow(i, 3);
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }

}
