package baekjoon.silver.Num15886;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String board = br.readLine();

        int answer = 0;
        for (int i = 0; i < N - 1; i++) {
            if (board.charAt(i) == 'E' && board.charAt(i + 1) == 'W') {
                answer++;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}