package baekjoon.bronze.Num18005;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int answer;
        if (n % 2 == 1) {
            answer = 0;
        } else if (n / 2 % 2 == 0) {
            answer = 2;
        } else {
            answer = 1;
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}