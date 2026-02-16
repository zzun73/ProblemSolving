package baekjoon.bronze.Num14038;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int win = 0;
        for (int i = 0; i < 6; i++) {
            if (br.readLine().equals("W")) {
                win++;
            }
        }

        int answer = (win >= 5) ? 1 :
                (win >= 3) ? 2 :
                        (win >= 1) ? 3 : -1;

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}