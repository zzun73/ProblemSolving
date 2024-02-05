package baekjoon.bronze.Num20540;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (char c : br.readLine().toCharArray()) {
            if (c == 'E') sb.append('I');
            else if (c == 'I') sb.append('E');
            else if (c == 'S') sb.append('N');
            else if (c == 'N') sb.append('S');
            else if (c == 'T') sb.append('F');
            else if (c == 'F') sb.append('T');
            else if (c == 'P') sb.append('J');
            else if (c == 'J') sb.append('P');
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}