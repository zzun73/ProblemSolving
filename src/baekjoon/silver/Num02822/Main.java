package baekjoon.silver.Num02822;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[8][2];
        for (int i = 1; i <= 8; i++) {
            int N = Integer.parseInt(br.readLine());
            arr[i - 1][0] = i;
            arr[i - 1][1] = N;
        }
        Arrays.sort(arr, Comparator.comparingInt(n -> -n[1]));
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int[] number = new int[5];
        for (int i = 0; i < 5; i++) {
            number[i] = arr[i][0];
            sum += arr[i][1];
        }
        sb.append(sum).append("\n");

        Arrays.sort(number);
        for (int num : number) {
            sb.append(num).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
