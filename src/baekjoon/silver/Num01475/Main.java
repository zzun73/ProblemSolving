package baekjoon.silver.Num01475;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10];
        int temp;

        while (N > 0) {
            temp = N % 10;
            arr[temp]++;
            N /= 10;
        }
        temp = arr[6] + arr[9];
        arr[6] = arr[9] = temp % 2 == 0 ? temp / 2 : (temp + 1) / 2;
        Arrays.sort(arr);
        bw.write(arr[9] + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
