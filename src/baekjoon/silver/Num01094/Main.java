package baekjoon.silver.Num01094;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int stick = 64;
        int answer = 0;
        int X = Integer.parseInt(br.readLine());

        while (X > 0) {
            if (stick > X) {
                stick /= 2;
            } else {
                answer++;
                X -= stick;
            }
        }
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
