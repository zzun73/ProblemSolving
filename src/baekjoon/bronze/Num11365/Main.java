package baekjoon.bronze.Num11365;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringBuilder str = new StringBuilder(br.readLine());
            if (str.toString().equals("END")) {
                break;
            }
            sb.append(str.reverse()).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
