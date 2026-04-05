package baekjoon.bronze.Num23037;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int answer = 0;
        while (num > 0) {
            int val = num % 10;
            num /= 10;
            answer += Math.pow(val, 5);
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}