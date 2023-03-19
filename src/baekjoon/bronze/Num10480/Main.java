package baekjoon.bronze.Num10480;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            int value = Integer.parseInt(br.readLine());
            if ((value & 1) == 0) {
                bw.write(value + " is even\n");
            } else {
                bw.write(value + " is odd\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
