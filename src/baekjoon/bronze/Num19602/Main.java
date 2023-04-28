package baekjoon.bronze.Num19602;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int S = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int L = Integer.parseInt(br.readLine());
        int happiness = S + (2 * M) + (3 * L);
        bw.write(happiness >= 10 ? "happy" : "sad");

        br.close();
        bw.flush();
        bw.close();
    }
}
