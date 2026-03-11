package baekjoon.bronze.Num15813;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int answer = N;
        for (char ch : br.readLine().toCharArray()) {
            answer += ch - 'A';
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}