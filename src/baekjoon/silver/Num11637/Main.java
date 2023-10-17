package baekjoon.silver.Num11637;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][2];
            int total = 0;
            for (int i = 0; i < n; i++) {
                arr[i][0] = i;
                arr[i][1] = Integer.parseInt(br.readLine());
                total += arr[i][1];
            }
            total /= 2;
            Arrays.sort(arr, (n1, n2) -> n2[1] - n1[1]);

            if (arr[0][1] == arr[1][1]) {
                sb.append("no winner");
            } else if (arr[0][1] > total) {
                sb.append("majority winner").append(" ").append(arr[0][0] + 1);
            } else {
                sb.append("minority winner").append(" ").append(arr[0][0] + 1);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}