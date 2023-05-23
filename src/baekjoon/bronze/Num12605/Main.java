package baekjoon.bronze.Num12605;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            String[] str = br.readLine().split(": ");
            sb.append("Case #").append(i).append(" ");
            for (int j = str.length - 1; j >= 0; j--) {
                sb.append(str[j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}
