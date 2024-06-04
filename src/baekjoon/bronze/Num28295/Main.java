package baekjoon.bronze.Num28295;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += Integer.parseInt(br.readLine());
        }

        if (sum % 4 == 0) {
            bw.write("N");
        } else if (sum % 4 == 1) {
            bw.write("E");
        } else if (sum % 4 == 2) {
            bw.write("S");
        } else if (sum % 4 == 3) {
            bw.write("W");
        }

        br.close();
        bw.close();
    }
}