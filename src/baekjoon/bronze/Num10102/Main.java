package baekjoon.bronze.Num10102;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();

        int result = 0;
        for (char ch : br.readLine().toCharArray()) {
            result += ch == 'A' ? 1 : -1;
        }

        bw.write(result == 0 ? "Tie" : result > 0 ? "A" : "B");

        br.close();
        bw.close();
    }
}