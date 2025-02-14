package baekjoon.bronze.Num02010;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer += Integer.parseInt(br.readLine());
        }
        answer -= (N - 1);
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}