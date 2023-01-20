package baekjoon.bronze.Num15727;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(br.readLine());
        int answer = 0;

        if (L % 5 != 0) {
            answer++;
        }
        answer += L / 5;

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
