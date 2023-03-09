package baekjoon.bronze.Num05524;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String Si = br.readLine();
            bw.write(Si.toLowerCase() + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
