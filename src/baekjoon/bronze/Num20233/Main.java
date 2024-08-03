package baekjoon.bronze.Num20233;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());
        int x = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());

        int result1 = a + ((Math.max(T, 30)) - 30) * x * 21;
        int result2 = b + ((Math.max(T, 45)) - 45) * y * 21;
        sb.append(result1).append(" ").append(result2);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}