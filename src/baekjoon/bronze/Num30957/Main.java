package baekjoon.bronze.Num30957;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int b = 0, s = 0, a = 0;
        for (char ch : br.readLine().toCharArray()) {
            if (ch == 'B') {
                b++;
            } else if (ch == 'S') {
                s++;
            } else if (ch == 'A') {
                a++;
            }
        }

        if (b == s && s == a) {
            sb.append("SCU");
        } else {
            int max = Math.max(b, Math.max(s, a));
            if (b == max) {
                sb.append('B');
            }
            if (s == max) {
                sb.append('S');
            }
            if (a == max) {
                sb.append('A');
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}