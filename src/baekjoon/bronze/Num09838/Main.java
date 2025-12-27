package baekjoon.bronze.Num09838;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[Integer.parseInt(br.readLine())] = i;
        }

        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}