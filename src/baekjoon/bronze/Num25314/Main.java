package baekjoon.bronze.Num25314;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String str = "long ";

        bw.write(str.repeat((N / 4) - 1) + "long int");

        br.close();
        bw.flush();
        bw.close();
    }
}
