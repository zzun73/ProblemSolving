package baekjoon.bronze.Num11721;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] str = br.readLine().toCharArray();
        int idx = 1;
        for (char c : str) {
            bw.write(c);
            if (idx % 10 == 0) {
                bw.write("\n");
            }
            idx++;
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
