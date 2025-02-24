package baekjoon.bronze.Num06888;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        for (int i = a; i <= b; i = i + 60) {
            sb.append("All positions change in year ").append(i).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}