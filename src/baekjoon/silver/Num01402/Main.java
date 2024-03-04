package baekjoon.silver.Num01402;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        br.readLine();
        bw.write("yes\n".repeat(T));

        br.close();
        bw.close();
    }
}
