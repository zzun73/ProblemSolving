package baekjoon.silver.Num01427;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int[] arr = new int[10];

        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - '0']++;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            while (arr[i]-- > 0) {
                bw.write(i + "");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
