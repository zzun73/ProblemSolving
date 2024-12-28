package baekjoon.silver.Num13597;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int number1 = Integer.parseInt(st.nextToken());
        int number2 = Integer.parseInt(st.nextToken());

        if (number1 == number2) {
            bw.write(String.valueOf(number1));
        } else {
            bw.write(String.valueOf(Math.max(number1, number2)));
        }

        br.close();
        bw.flush();
        bw.close();
    }
}