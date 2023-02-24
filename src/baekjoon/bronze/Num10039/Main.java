package baekjoon.bronze.Num10039;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;
        for (int i = 0; i < 5; i++) {
            int score = Integer.parseInt(br.readLine());
            if (score < 40) {
                score = 40;
            }
            answer += score;
        }
        bw.write(answer / 5 + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
