package baekjoon.bronze.Num29766;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int answer = 0;
        for (int i = 0; i < str.length() - 3; i++) {
            if (str.charAt(i) == 'D' && str.charAt(i + 1) == 'K' && str.charAt(i + 2) == 'S' && str.charAt(i + 3) == 'H') {
                answer++;
            }
        }
        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}