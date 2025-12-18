package baekjoon.bronze.Num32342;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String str = br.readLine();
            int count = 0;
            for (int i = 0; i < str.length() - 2; i++) {
                char first = str.charAt(i);
                char second = str.charAt(i + 1);
                char third = str.charAt(i + 2);
                if (first == 'W' && second == 'O' && third == 'W') {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}