package baekjoon.bronze.Num27332;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        int days = A + 7 * B;
        if (days >= 1 && days <= 30) {
            bw.write("1");
        } else {
            bw.write("0");
        }

        br.close();
        bw.close();
    }
}