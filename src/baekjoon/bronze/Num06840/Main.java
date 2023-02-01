package baekjoon.bronze.Num06840;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[3];
        int i = -1;

        while (++i < 3) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        bw.write(arr[1] + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
