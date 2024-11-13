package baekjoon.bronze.Num04766;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        double num1 = Double.parseDouble(br.readLine());

        while (true) {
            double num2 = Double.parseDouble(br.readLine());

            if (num2 == 999) {
                break;
            }

            sb.append(String.format("%.2f\n", (num2 - num1)));
            num1 = num2;
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}