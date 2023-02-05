package baekjoon.silver.Num01541;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stMinus;
        StringTokenizer stPlus;

        stMinus = new StringTokenizer(br.readLine(), "-");
        boolean check = false;
        int value, answer = 0;
        while (stMinus.hasMoreTokens()) {
            value = 0;
            stPlus = new StringTokenizer(stMinus.nextToken(), "+");

            while (stPlus.hasMoreTokens()) {
                value += Integer.parseInt(stPlus.nextToken());
            }

            if (!check) {
                check = true;
                answer += value;
            } else {
                answer -= value;
            }
        }

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
