package baekjoon.bronze.Num23795;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;
        while (true) {
            int val = Integer.parseInt(br.readLine());
            if (val == -1) {
                break;
            }
            answer += val;
        }
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
