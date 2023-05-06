package baekjoon.bronze.Num05988;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String[] str = br.readLine().split("");
            bw.write(Integer.parseInt(str[str.length - 1]) % 2 == 0 ? "even\n" : "odd\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
