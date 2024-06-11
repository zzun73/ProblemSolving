package baekjoon.bronze.Num26264;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int sCount = 0, bCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equals("s")) {
                sCount++;
            } else if (str.substring(i, i + 1).equals("b")) {
                bCount++;
            }
        }

        if (sCount == bCount) {
            bw.write("bigdata? security!");
        } else if (bCount > sCount) {
            bw.write("bigdata?");
        } else {
            bw.write("security!");
        }

        br.close();
        bw.close();
    }
}