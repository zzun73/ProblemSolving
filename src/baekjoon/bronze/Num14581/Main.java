package baekjoon.bronze.Num14581;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String id = br.readLine();

        bw.write(":fan::fan::fan:\n"
                + ":fan::" + id + "::fan:\n"
                + ":fan::fan::fan:");

        br.close();
        bw.flush();
        bw.close();
    }
}
