package baekjoon.bronze.Num26736;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        int A = 0, B = 0;
        for (char ch : br.readLine().toCharArray()) {
            if (ch == 'A') A++;
            if (ch == 'B') B++;
        }

        sb.append(A).append(" : ").append(B);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}