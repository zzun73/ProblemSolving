package baekjoon.bronze.Num17009;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = 0, B = 0;
        for (int i = 3; i >= 1; i--) {
            A += i * Integer.parseInt(br.readLine());
        }
        for (int i = 3; i >= 1; i--) {
            B += i * Integer.parseInt(br.readLine());
        }
        bw.write(A > B ? "A" : A < B ? "B" : "T");

        br.close();
        bw.flush();
        bw.close();
    }
}
