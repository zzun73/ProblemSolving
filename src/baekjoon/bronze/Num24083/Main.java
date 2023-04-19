package baekjoon.bronze.Num24083;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int answer = (A + B) % 12;
        bw.write(answer == 0 ? "12" : answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
