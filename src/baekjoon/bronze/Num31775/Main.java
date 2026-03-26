package baekjoon.bronze.Num31775;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean isK = false;
        boolean isL = false;
        boolean isP = false;

        for (int i = 0; i < 3; i++) {
            char prefix = br.readLine().charAt(0);

            if (prefix == 'k') {
                isK = true;
            } else if (prefix == 'l') {
                isL = true;
            } else if (prefix == 'p') {
                isP = true;
            }
        }

        bw.write((isK && isL && isP) ? "GLOBAL" : "PONIX");

        br.close();
        bw.close();
    }
}