package baekjoon.bronze.Num10205;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int c = Integer.parseInt(br.readLine());
            for (char ch : br.readLine().toCharArray()) {
                c += ch == 'c' ? 1 : -1;
            }

            if (t != 1) {
                sb.append("\n");
            }
            sb.append("Data Set ").append(t).append(":\n").append(c).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}