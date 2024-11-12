package baekjoon.bronze.Num30402;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String answer = "";
        for (int i = 0; i < 15; i++) {
            for (char ch : br.readLine().toCharArray()) {
                answer = switch (ch) {
                    case 'w' -> "chunbae";
                    case 'b' -> "nabi";
                    case 'g' -> "yeongcheol";
                    default -> answer;
                };
            }
        }
        bw.write(answer);

        br.close();
        bw.close();
    }
}