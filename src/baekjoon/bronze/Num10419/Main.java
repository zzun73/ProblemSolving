package baekjoon.bronze.Num10419;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int d = Integer.parseInt(br.readLine());
            int answer = 1;

            while (answer + (answer * answer) <= d) {
                answer++;
            }

            sb.append(answer - 1).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}