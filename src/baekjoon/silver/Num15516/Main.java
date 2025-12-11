package baekjoon.silver.Num15516;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j]){
                    count++;
                }
            }
            sb.append(count).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}