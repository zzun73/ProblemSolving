package baekjoon.bronze.Num26040;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        for (char ch : br.readLine().toCharArray()) {
            String target = String.valueOf(ch);
            str = str.replaceAll(target, target.toLowerCase());
        }

        bw.write(str);

        br.close();
        bw.close();
    }
}