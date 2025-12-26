package baekjoon.bronze.Num34032;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for (char ch : br.readLine().toCharArray()) {
            if (ch == 'O') {
                count++;
            }
        }

        bw.write(count >= (N + 1) / 2 ? "Yes" : "No");

        br.close();
        bw.close();
    }
}