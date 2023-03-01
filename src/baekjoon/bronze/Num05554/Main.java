package baekjoon.bronze.Num05554;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int time = 0;
        for (int i = 0; i < 4; i++) {
            time += Integer.parseInt(br.readLine());
        }
        int x = time / 60;
        int y = time % 60;

        bw.write(x + "\n" + y);

        br.close();
        bw.flush();
        bw.close();
    }
}
