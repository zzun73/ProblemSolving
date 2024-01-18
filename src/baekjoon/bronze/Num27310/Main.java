package baekjoon.bronze.Num27310;

import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();
        int answer = input.length;
        int underbar = 0;
        for (char c : input) {
            if (c == '_') {
                underbar++;
            } else if (c == ':') {
                answer++;
            }
        }
        answer += underbar * 5;
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}
