package baekjoon.bronze.Num12790;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[8];
            for (int i = 0; i < 8; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < 4; i++) {
                arr[i] += arr[i + 4];
            }

            arr[0] = Math.max(arr[0], 1);
            arr[1] = Math.max(arr[1], 1);
            arr[2] = Math.max(arr[2], 0);

            int result = arr[0] + (arr[1] * 5) + (arr[2] * 2) + (arr[3] * 2);
            sb.append(result).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}