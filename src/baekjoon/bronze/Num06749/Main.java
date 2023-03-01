package baekjoon.bronze.Num06749;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int low = Integer.parseInt(br.readLine());
        int middle = Integer.parseInt(br.readLine());
        int high = middle - low + middle;

        bw.write(high + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
