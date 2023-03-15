package baekjoon.bronze.Num10768;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int month = Integer.parseInt(br.readLine());
        int day = Integer.parseInt(br.readLine());

        if (month < 2) {
            bw.write("Before");
        } else if (month == 2) {
            if (day < 18) {
                bw.write("Before");
            } else if (day == 18) {
                bw.write("Special");
            } else {
                bw.write("After");
            }
        } else {
            bw.write("After");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
