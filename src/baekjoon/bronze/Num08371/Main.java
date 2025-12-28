package baekjoon.bronze.Num08371;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String original = br.readLine();
        String str = br.readLine();

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (original.charAt(i) != str.charAt(i)) {
                count++;
            }
        }

        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }
}