package baekjoon.silver.Num11656;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        String[] str = new String[S.length()];
        for (int i = 0; i < str.length; i++) {
            str[i] = S.substring(i);
        }
        Arrays.sort(str);

        for (String string: str) {
            bw.write(string+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
