package baekjoon.bronze.Num26574;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            bw.write(x + " " + x + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
