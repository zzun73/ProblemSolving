package baekjoon.bronze.Num10811;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            int swap;
            while (i <= j) {
                swap = arr[i];
                arr[i++] = arr[j];
                arr[j--] = swap;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
