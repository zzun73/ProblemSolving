package baekjoon.bronze.Num03449;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.equals("***")) {
                break;
            }
            StringBuilder cur = new StringBuilder(str);

            sb.append(cur.reverse()).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}