package baekjoon.bronze.Num16017;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[4];
        boolean flag = true;

        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if ((i == 0 || i == 3) && !(8 <= arr[i])) {
                flag = false;
            }
            if (i == 2 && arr[i] != arr[i - 1]) {
                flag = false;
            }
        }
        bw.write(flag ? "ignore" : "answer");

        br.close();
        bw.close();
    }
}