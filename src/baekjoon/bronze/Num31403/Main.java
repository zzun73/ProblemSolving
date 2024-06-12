package baekjoon.bronze.Num31403;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int resultNumber = A + B - C;
        int resultString = Integer.parseInt(String.valueOf(A) + B) - C;
        sb.append(resultNumber).append("\n").append(resultString);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}