package baekjoon.silver.Num01769;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String X = br.readLine();
        int count = 0;
        while (X.length() > 1) {
            int Y = 0;
            for (int i = 0; i < X.length(); i++) {
                Y += X.charAt(i) - '0';
            }
            X = String.valueOf(Y);
            count++;
        }

        sb.append(count).append("\n").append(Integer.parseInt(X) % 3 == 0  ? "YES" : "NO");

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}