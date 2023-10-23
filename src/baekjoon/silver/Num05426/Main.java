package baekjoon.silver.Num05426;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            int len = str.length();
            int size = 1;
            while (size * size != len) {
                size++;
            }
            int idx = 0;
            char[][] ch = new char[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    ch[i][j] = str.charAt(idx++);
                }
            }

            for (int j = size - 1; j >= 0; j--) {
                for (int i = 0; i < size; i++) {
                    sb.append(ch[i][j]);
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}